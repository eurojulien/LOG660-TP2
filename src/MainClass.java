import java.util.ArrayList;




public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Facade facade = Facade.getFacade();
		
		Utilisateur user = facade.getUser("AurelioJSmith60@gmail.com", "mew2Veifo");
		
		System.out.println("user : " + user.getNomfamille());
		
		//System.out.println(facade.getForfait("1").toString());
		// Insertion usager
		/*facade.addUser(	"1001",
						"Julien",
						"LeGamin",
						"employe",
						"514 999-8888",
						"eurojulien@gmail.com",
						"5541",
						"Basile",
						"Montreal",
						"Quebec",
						"H4C 1C5",
						"1983/12/29",
						"julien",
						"thisisatest");
		
		
		/* Film film = facade.getFilm("34492");
		System.out.println("Film : " + film.getResume());
		
		ArrayList<Film> films = facade.getFilms();
		
		for (Film movie : films){
			System.out.println("Description : " + movie.getResume());
		} */
	}

}
