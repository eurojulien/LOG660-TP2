package controlleur;

import vue.MenuPrincipal;

public class MenuControlleur {

	private LoginControlleur loginControlleur;
	
	private MenuPrincipal menuGui;
	
	public MenuControlleur(LoginControlleur loginControlleur){
		this.loginControlleur = loginControlleur;
		this.menuGui = new MenuPrincipal(this);
	}
	
	public void showGui(){
		this.menuGui.setVisible(true);
		this.menuGui.setUserInfo(loginControlleur.getUser().getIdutilisateur().toPlainString());
	}
	
	public void hideGui(){
		this.menuGui.setVisible(false);
	}

	public void userClosedWindow() {
		hideGui();
		loginControlleur.showGui();
	}
}
