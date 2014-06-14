package controlleur;

import java.util.ArrayList;
import java.util.Calendar;

import vue.ListFilmLouer;
import modele.Exemplaire;
import modele.Film;
import modele.Locationfilm;
import modele.LocationfilmId;
import modele.Utilisateur;

public class LouerControlleur {

	private Utilisateur user;
	
	private MenuControlleur menucont;
	private RechercheFilmCont recheFilmCont;
	
	private ListFilmLouer listFilmLouerGui;
	
	private ArrayList<Exemplaire> listExemplaire;
	
	public LouerControlleur(MenuControlleur menucont, Utilisateur user){
		this.menucont = menucont;
		this.user = user;
		this.listExemplaire = new ArrayList<Exemplaire>();
		this.listFilmLouerGui = new ListFilmLouer(this);
		this.recheFilmCont = new RechercheFilmCont(this);
	}

	public void showGui() {
		listFilmLouerGui.setVisible(true);
	}
	
	public void hideGui(){
		listFilmLouerGui.setVisible(false);
	}
	
	public void userClosedWindow() {
		hideGui();
		menucont.showGui();
	}
	
	public int checkNombreDeFilmDejaSortiParLeUser(){
		int num = 0;
		Facade f = Facade.getFacade();
		ArrayList<Locationfilm> listDeFilmSorti = (ArrayList<Locationfilm>) f.getObjects(Locationfilm.class, 
				"idutilisateur = " + user.getIdutilisateur().intValue() , "datederetour = null"); //null parceque le film na
		
		return listDeFilmSorti.size();
	}
	
	public void ajouterFilmALouer(Exemplaire exemplaire){
		listExemplaire.add(exemplaire);
		listFilmLouerGui.clearList();
		for(Exemplaire e : listExemplaire){
			listFilmLouerGui.addFilm(e.getFilm().getTitre());
		}
	}
	
	public void enleverFilm(int index){
		listExemplaire.remove(index);
		listFilmLouerGui.clearList();
		for(Exemplaire e : listExemplaire){
			listFilmLouerGui.addFilm(e.getFilm().getTitre());
		}
	}
	
	public void louer(){
		
		if(checkNombreDeFilmDejaSortiParLeUser() + listExemplaire.size() <= user.getForfait().getLocationmax().intValue()){
			
			for(Exemplaire exem : listExemplaire){
				
				Locationfilm locFilm = new Locationfilm();
				LocationfilmId locFilmId = new LocationfilmId();
				Calendar cal = Calendar.getInstance();
				
				exem.setDisponible(false);
				
				locFilmId.setIdutilisateur(user.getIdutilisateur());
				locFilmId.setIdexemplaire(exem.getIdexemplaire());
				
				locFilm.setId(locFilmId);
				locFilm.setDatedelocation(cal.getTime());
				
				//Date de retour content quand il c'est fait retourner
				// et ne devrais pas contenir quand il est supposer etre retourner!
				/*if(user.getForfait().getDureemax().intValue() != 0){
					cal.add(Calendar.DATE, user.getForfait().getDureemax().intValue());
					locFilm.setDatederetour(cal.getTime());
				}*/
				
				Facade f = Facade.getFacade();
				
				f.saveOrUpdateObject(Exemplaire.class, exem);
				//f.saveOrUpdateObject(LocationfilmId.class, locFilmId);
				f.saveOrUpdateObject(Locationfilm.class, locFilm);
				//Je suis pas sur si cela va marcher, je pense que LocationFilm et LocationFilmId
				//doive entre commit dans la meme transaction
			}
			
			userClosedWindow();
			
		}
		else{
			listFilmLouerGui.showErrorMessage("Vous ne pouvez pas sortir au tants de film avec votre forfait. " + 
											"SVP retourner des films ou enlever des films de vous choix de location");
		}
	}

	public void partirRecherche() {
		hideGui();
		recheFilmCont.showGuiRecherche();
		
	}
}
