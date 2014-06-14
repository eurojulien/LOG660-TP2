package controlleur;

import java.util.ArrayList;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import vue.Login;
import modele.Forfait;
import modele.Utilisateur;

public class LoginControlleur{

	private Utilisateur user;
	
	private Login loginGui;
	
	private MenuControlleur menuControlleur;
	
	public LoginControlleur(){
		this.loginGui = new Login(this);
		
	}
	
	public void showGui(){
		this.loginGui.setVisible(true);
	}
	
	public void hideGui(){
		this.loginGui.setVisible(false);
	}
	
	public void userClosedWindow(){
		Facade facade = Facade.getFacade();
		facade.closeSessionForExit();
		hideGui();
		System.exit(0);
	}
	
	public void LoginCheck(String username, String pass){
		
		//if login is good, then
			//create object Utilisateur and the the details for that user
			//tell gui to continue to next screen
		//else
			//tell GUI to show error message
		
		Facade facade = Facade.getFacade();

		ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) facade.getObjects(Utilisateur.class, 
							"identificateur = '" + username + "'", 
							"motdepasse = '" + pass + "'");
		
		if(!users.isEmpty()){
			user = users.get(0);
			System.out.println("Forfait: " + user.getForfait().getNom());
			hideGui(); //hide the login screen
			menuControlleur = new MenuControlleur(this);
			menuControlleur.showGui(); //show the main menu
		}else 
		{
			loginGui.setTextOnlblMessage("Error: Nom d'utilisateur ou/et Mot de passe invalide!");
		}
		
	}
	
	public Utilisateur getUser(){
		return this.user;
	}
}
