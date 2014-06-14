package controlleur;

import java.util.ArrayList;
import java.util.Calendar;

import modele.Exemplaire;
import modele.Film;
import modele.Locationfilm;
import modele.LocationfilmId;
import modele.Utilisateur;

public class LouerControlleur {

	private Utilisateur user;
	
	private MenuControlleur menucont;
	//private RechercheFilmCont reFilmCont;
	
	//private LoyerGui loyerGui;
	
	ArrayList<Film> listFilm;
	
	public LouerControlleur(MenuControlleur menucont, Utilisateur user){
		this.menucont = menucont;
		this.user = user;
		this.listFilm = new ArrayList<Film>();
	}

	public void showGui() {
		//loyerGui.setVisible(true);
	}
	
	public void hideGui(){
		//loyerGui.setVisible(false);
	}
	
	public void userClosedWindow() {
		hideGui();
		menucont.showGui();
	}
	
	public int checkNombreDeFilmDejaSorti(){
		int num = 0;
		
		return num;
	}
	
	public void ajouterFilmALouer(Film film){
		listFilm.add(film);
		//loyerGui.addFilmALaVue(film.getTitre());
	}
	
	public void enleverFilm(){
		//TODO
	}
	
	public Exemplaire getExmplaireDisponiblePourFilm(int filmId){
		Exemplaire exem = null;
		Facade f = Facade.getFacade();
		ArrayList<Exemplaire> exemplaires = (ArrayList<Exemplaire>) f.getObjects(Exemplaire.class, 
				"idfilm = " + filmId );
		
		return exemplaires.get(0);
	}
	
	public void louer(){

		if(checkNombreDeFilmDejaSorti() + listFilm.size() > user.getForfait().getLocationmax().intValue()){
			
			for(Film film : listFilm){
				Exemplaire exem = getExmplaireDisponiblePourFilm(film.getIdfilm().intValue());
				Locationfilm locFilm = new Locationfilm();
				LocationfilmId locFilmId = new LocationfilmId();
				Calendar cal = Calendar.getInstance();
				
				exem.setDisponible(false);
				
				locFilmId.setIdutilisateur(user.getIdutilisateur());
				locFilmId.setIdexemplaire(exem.getIdexemplaire());
				
				locFilm.setId(locFilmId);
				locFilm.setDatedelocation(cal.getTime());
				
				if(user.getForfait().getDureemax().intValue() != 0){
					cal.add(Calendar.DATE, user.getForfait().getDureemax().intValue());
					locFilm.setDatederetour(cal.getTime());
				}
				
				Facade f = Facade.getFacade();
				
				f.saveOrUpdateObject(Exemplaire.class, exem);
				f.saveOrUpdateObject(LocationfilmId.class, locFilmId);
				f.saveOrUpdateObject(Locationfilm.class, locFilm);
				//Je suis pas sur si cela va marcher, je pense que LocationFilm et LocationFilmId
				//doive entre commit dans la meme transaction
			}
			
		}
		else{
			//loyerGui.setTextOnlblMessage("Vous ne pouvez pas sortir au tants de film avec votre forfait. " + 
			//								"SVP retourner des films ou enlever des films de vous choix de location");
		}
	}
}
