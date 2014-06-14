package controlleur;

import vue.ListFilm;
import vue.RechercherFilm;

public class RechercheFilmCont {

	private LouerControlleur louerControlleur;
	
	private RechercherFilm rechercherFilmGui;
	private ListFilm	listFilmGui;
	
	public RechercheFilmCont(LouerControlleur louerControlleur) {
		this.louerControlleur = louerControlleur;
		this.rechercherFilmGui = new RechercherFilm(this);
		this.listFilmGui = new ListFilm(this);
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
	
	public void hideResultat(){
		listFilmGui.setVisible(false);
	}

}
