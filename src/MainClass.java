import java.util.ArrayList;
import java.util.List;

import javassist.bytecode.Descriptor.Iterator;
import vue.Login;
import controlleur.Facade;
import controlleur.LoginControlleur;
import modele.*;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Facade facade = Facade.getFacade();
		
//		ArrayList<Film> films = (ArrayList<Film>) facade.getObjects(Film.class, "idFilm = 34492");
//		Film film = films.get(0);
//		System.out.println("Film : " + film.getResume());
//		facade.initObject(film);
//		List<Annonce> list = new ArrayList<Annonce>(film.getAnnonces());

//		for(Annonce ann : list){
//			System.out.println(ann.getAnnounce());
//		}
		
//		
//		ArrayList<Exemplaire> exe = (ArrayList<Exemplaire>) facade.getObjects(Exemplaire.class,"idFilm = " + films.get(0).getIdfilm().toPlainString());
//		System.out.println("Exemplaires : " + exe.get(0).getIdexemplaire());
		
		//new Login().setVisible(true);
		
		LoginControlleur loginControlleur = new LoginControlleur();
		loginControlleur.showGui();
	}

}
