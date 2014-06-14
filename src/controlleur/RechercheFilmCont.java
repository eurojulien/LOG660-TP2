package controlleur;

import java.util.ArrayList;
import java.util.Iterator;

import modele.Annonce;
import modele.Exemplaire;
import modele.Film;
import modele.Genre;
import modele.Implication;
import modele.Pays;
import vue.ListFilm;
import vue.RechercherFilm;

public class RechercheFilmCont {

	private LouerControlleur louerControlleur;
	
	private RechercherFilm rechercherFilmGui;
	private ListFilm	listFilmGui;
	
	private ArrayList<Film> filmResltat;
	
	public RechercheFilmCont(LouerControlleur louerControlleur) {
		this.louerControlleur = louerControlleur;
		this.rechercherFilmGui = new RechercherFilm(this);
		this.listFilmGui = new ListFilm(this);
		this.filmResltat = new ArrayList<Film>();
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

	public void rechercheFilmParTitre(String titre){
		listFilmGui.clearList();
		
		Facade f = Facade.getFacade();
		
		filmResltat = (ArrayList<Film>) f.getObjects(Film.class, 
										"titre = '" + titre + "'");
		if(filmResltat.isEmpty())
			rechercherFilmGui.showErrorMessage("Aucun film trouver.");
		else{
			for(Film film: filmResltat){
				listFilmGui.addFilm(film.getTitre());	
			}
			hideGuiRecherche();
			showGuiResultat();
		}

	}
	
	public void affichierFicheFilm(int index){
		Film film = filmResltat.get(index);
		System.out.println("Film :" + film.getTitre());
		System.out.println("Langue :" + film.getLangue());
		System.out.println("Image :" + film.getImage());
		System.out.println("Resume :" + film.getResume());
		System.out.println("Anneesortie :" + film.getAnneesortie());
		System.out.println("Duree :" + film.getDuree());
		System.out.println("Idfilm :" + film.getIdfilm());
		
		ArrayList<Annonce> listAnnonce = new ArrayList<Annonce>();
		listAnnonce.addAll(film.getAnnonces());
		for(Annonce a : listAnnonce){
			System.out.println("Annonce :" + a.getAnnounce());
		}
		
		ArrayList<Genre> listGenre = new ArrayList<Genre>();
		listGenre.addAll(film.getGenres());
		for(Genre g : listGenre){
			System.out.println("Genre :" + g.getLibellegenre());
		}
		
		ArrayList<Pays> listPays = new ArrayList<Pays>();
		listPays.addAll(film.getPayses());
		for(Pays p : listPays){
			System.out.println("Genre :" + p.getNompays());
		}
		
		ArrayList<Implication> listImp = new ArrayList<Implication>();
		listImp.addAll(film.getImplications());
		for(Implication i : listImp){
			System.out.println("Type Personne: " + i.getTypepersonne().getTypepersonne());
			System.out.println("Nom :" + i.getPersonne().getPrenom() + " " + i.getPersonne().getNom());
			if(i.getPersonne().getDatedenaissance() != null)
				System.out.println("DateAnniv. :" + i.getPersonne().getDatedenaissance().toString());
			System.out.println("Personnage: " + i.getPersonnage());
		}
	}
}