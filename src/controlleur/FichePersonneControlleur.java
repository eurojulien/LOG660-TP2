package controlleur;
import vue.FichePersonne;
import modele.Personne;

public class FichePersonneControlleur {
	
	FichePersonne fiche;
	
	public FichePersonneControlleur(Personne personne){
		
		fiche = new FichePersonne();
		fiche.showPersonInformations(personne);
		fiche.setVisible(true);
	}
}
