import java.util.ArrayList;

import vue.Login;
import controlleur.Facade;
import modele.*;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Facade facade = Facade.getFacade();
//		
//		ArrayList<Film> films = (ArrayList<Film>) facade.getObjects(Film.class, "idFilm = 34492");
//		System.out.println("Film : " + films.get(0).getResume());
//		
//		ArrayList<Exemplaire> exe = (ArrayList<Exemplaire>) facade.getObjects(Exemplaire.class,"idFilm = " + films.get(0).getIdfilm().toPlainString());
//		System.out.println("Exemplaires : " + exe.get(0).getIdexemplaire());
		
		new Login().setVisible(true);;
	}

}
