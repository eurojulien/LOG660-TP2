package controlleur;

import java.util.ArrayList;
import java.util.Iterator;

import modele.Exemplaire;
import modele.Film;
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
}
