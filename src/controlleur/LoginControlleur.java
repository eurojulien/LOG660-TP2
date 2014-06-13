package controlleur;

import modele.Utilisateur;

public class LoginControlleur extends Facade{

	private Utilisateur user;
	
	LoginControlleur(){
		super();
		//start gui
	}
	
	public void LoginCheck(String username, String pass){
		
		//if login is good, then
			//create object Utilisateur and the the details for that user
			//tell gui to continue to next screen
		//else
			//tell GUI to show error message
	}
}
