package controlleur;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

import modele.*;
import vue.FicheFilm;
import vue.ListFilm;
import vue.RechercherFilm;

public class RechercheFilmCont {

	private LouerControlleur louerControlleur;
	
	private RechercherFilm rechercherFilmGui;
	private ListFilm	listFilmGui;
	private FicheFilm 	ficheFilmGui;
	
	private ArrayList<Film> filmResltat;
	
	public RechercheFilmCont(LouerControlleur louerControlleur) {
		this.louerControlleur = louerControlleur;
		this.rechercherFilmGui = new RechercherFilm(this);
		this.listFilmGui = new ListFilm(this);
		this.filmResltat = new ArrayList<Film>();
		
		loadPays();
		loadGenre();
		loadlangue();

	}

	public void showGuiRecherche() {
		rechercherFilmGui.setVisible(true);
	}
	
	public void showGuiResultat(){
		listFilmGui.setVisible(true);
	}
	
	public void hideGuiRecherche() {
		rechercherFilmGui.setVisible(false);
	}
	
	public void hideGuiResultat(){
		listFilmGui.setVisible(false);
	}

	public void userClosedWindowRechercher() {
		hideGuiRecherche();
		hideGuiResultat();
		louerControlleur.showGui();
	}

	public void userClosedWindowResultat() {
		hideGuiResultat();
		showGuiRecherche();
	}

	public void addLoction(int selectedIndex) {
		//System.out.println("Film selected to rent: " + filmResltat.get(selectedIndex).getTitre());
		
		//Check pour un exemplaire disponible!
		/*Facade f = Facade.getFacade();
		int idfilm = filmResltat.get(selectedIndex).getIdfilm().intValue();
		ArrayList<Exemplaire> listExemplaire = (ArrayList<Exemplaire>)f.getObjects(Exemplaire.class, 
													"idfilm = " + idfilm, 
													"disponible = " + 1); //1 pour true
		*/
		/*if(listExemplaire.isEmpty()){
			listFilmGui.showErrorMessage("Aucune exemplaire de ce film sont disponible");
		}
		else{
			louerControlleur.ajouterFilmALouer(listExemplaire.get(0));
			userClosedWindowRechercher();
		}*/
		
		//better way, since hibernate has the objects already
		Film film = filmResltat.get(selectedIndex);
		
		ArrayList<Exemplaire> theList = new ArrayList<Exemplaire>();
		theList.addAll(film.getExemplaires());
		for(int i = 0; i < theList.size(); i++){
			Exemplaire exem = theList.get(i);
			if(exem.isDisponible()){
				louerControlleur.ajouterFilmALouer(exem);
				userClosedWindowRechercher();
				break;
			}
			if(!exem.isDisponible() && i == theList.size()-1)//
			{
				listFilmGui.showErrorMessage("Aucune exemplaire de ce film sont disponible");
				break;
			}
		}
		

	}
	
	public void addLoction(Film film) {
		
		ArrayList<Exemplaire> theList = new ArrayList<Exemplaire>();
		theList.addAll(film.getExemplaires());
		for(int i = 0; i < theList.size(); i++){
			Exemplaire exem = theList.get(i);
			if(exem.isDisponible()){
				louerControlleur.ajouterFilmALouer(exem);
				ficheFilmGui.setVisible(false);
				listFilmGui.setVisible(false);
				rechercherFilmGui.setVisible(false);
				louerControlleur.showGui();
				break;
			}
			if(!exem.isDisponible() && i == theList.size()-1)//
			{
				listFilmGui.showErrorMessage("Aucune exemplaire de ce film sont disponible");
				break;
			}
		}
		

	}

	public void rechercheFilmParTitre(String titre){
		listFilmGui.clearList();
		
		Facade f = Facade.getFacade();
		
		filmResltat = (ArrayList<Film>) f.getObjects(Film.class, 
										"titre LIKE '%" + titre + "%'");
		if(filmResltat.isEmpty())
			rechercherFilmGui.showErrorMessage("Aucun film trouver.");
		else{
			for(Film film: filmResltat){
				listFilmGui.addFilm(film.getTitre());	
			}
			listFilmGui.clearList();
			hideGuiRecherche();
			showGuiResultat();
		}

	}
	
	public Film rechercheFilmParId(BigDecimal idfilm){
		listFilmGui.clearList();
		
		Facade f = Facade.getFacade();
		
		ArrayList<Film> filmRecu = (ArrayList<Film>) f.getObjects(Film.class, 
										"idfilm = " + idfilm );

		return filmRecu.get(0);
	}
	
	public void rechercheFilmFonctionAwesome(String titre,
												String pays,
												String langue, 
												int idGenre,
												String realisateur,
												String Acteur,
												Date after, 
												Date before){
		
		String queryString = "SELECT idfilm FROM film WHERE ";
		if(titre != null)
			queryString= queryString + "titre LIKE '%" + titre + "%' ";
		//etc.....
		
		
		
		ArrayList<BigDecimal> listIdFilm = Facade.getFacade().normalSQLSelect(queryString);
		
		listFilmGui.clearList();
		filmResltat.clear();
		
		if(listIdFilm.isEmpty())
			rechercherFilmGui.showErrorMessage("Aucun film trouver.");
		else{
			for(BigDecimal s : listIdFilm){
				Film f = rechercheFilmParId(s);
				if(f != null)
					filmResltat.add(f);
			}
			if(!filmResltat.isEmpty()){
				for(Film film: filmResltat){
					listFilmGui.addFilm(film.getTitre());	
				}
				hideGuiRecherche();
				showGuiResultat();
			}

		}
		
	}
	
	public void affichierFicheFilm(int index){
		Film film = filmResltat.get(index);
		hideGuiResultat();
		ficheFilmGui = new FicheFilm(this, film);
		ficheFilmGui.setVisible(true);
	}
	
	public void userClosedFicheFilm() {
		ficheFilmGui.setVisible(false);
		showGuiResultat();
	}
	
	public void loadPays(){
		//http://stackoverflow.com/questions/5010537/java-swing-jcombobox-is-it-possible-to-have-hidden-data-for-each-item-in-the-l
		
		Facade f = Facade.getFacade();
		
		Vector model = null;
		ArrayList<Pays> pays = (ArrayList<Pays>) f.getAllObjects(Pays.class);
		
		model = new Vector();
        model.addElement( new Item(0, "" ) );
		rechercherFilmGui.addPays(model);
		for (Pays p : pays){
	     	model = new Vector();
	        model.addElement( new Item(p.getIdpays().intValue(), p.getNompays() ) );
	        rechercherFilmGui.addPays(model);
		}

	}
	
	public void loadGenre(){
		
		Facade f = Facade.getFacade();
		
		Vector model = null;
		ArrayList<Genre> genres = (ArrayList<Genre>) f.getAllObjects(Genre.class);
		rechercherFilmGui.addGenre("");
		for (Genre g : genres){
			model = new Vector();
			model.addElement( new Item(g.getIdgenre().intValue(), g.getLibellegenre()));
			rechercherFilmGui.addGenre(g.getLibellegenre());
		}
	}
	
	public void loadlangue(){

		String query = "SELECT DISTINCT langue FROM film";
		Facade f = Facade.getFacade();
		
		ArrayList<String> listLangue = f.normalSQLSelect(query);
		rechercherFilmGui.addLangue("");
		for (String s : listLangue){
			rechercherFilmGui.addLangue(s);
		}
	}
	
	
}
