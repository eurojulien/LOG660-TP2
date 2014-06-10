import java.util.ArrayList;

import controlleur.Facade;
import modele.*;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Facade facade = Facade.getFacade();
		
		ArrayList<Film> films = (ArrayList<Film>) facade.getObjects(Film.class, "idFilm = 34492");
		System.out.println("Film : " + films.get(0).getResume());
		
		ArrayList<Exemplaire> exe = (ArrayList<Exemplaire>) facade.getObjects(Exemplaire.class,"idFilm = " + films.get(0).getIdfilm().toPlainString());
		System.out.println("Exemplaires : " + exe.get(0).getIdexemplaire());
		
		ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) facade.getObjects(Utilisateur.class, "identificateur = '11'", "motdepasse = '22'");
		//ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) facade.getObjects(Utilisateur.class, "identificateur = 'DanaJDixon99@yahoo.com'", "motdepasse = 'uhohHequ1'");
		
		for (Utilisateur user : users){
			System.out.println(" USAGER -> " + user.getNomfamille() + " " + user.getPrenom());
		}
	}

}
