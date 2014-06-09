package modele;

// Generated Jun 9, 2014 4:05:17 PM by Hibernate Tools 4.0.0

/**
 * Implication generated by hbm2java
 */
public class Implication implements java.io.Serializable {

	private ImplicationId id;
	private Typepersonne typepersonne;
	private Film film;
	private Personne personne;
	private String personnage;

	public Implication() {
	}

	public Implication(ImplicationId id, Typepersonne typepersonne, Film film,
			Personne personne) {
		this.id = id;
		this.typepersonne = typepersonne;
		this.film = film;
		this.personne = personne;
	}

	public Implication(ImplicationId id, Typepersonne typepersonne, Film film,
			Personne personne, String personnage) {
		this.id = id;
		this.typepersonne = typepersonne;
		this.film = film;
		this.personne = personne;
		this.personnage = personnage;
	}

	public ImplicationId getId() {
		return this.id;
	}

	public void setId(ImplicationId id) {
		this.id = id;
	}

	public Typepersonne getTypepersonne() {
		return this.typepersonne;
	}

	public void setTypepersonne(Typepersonne typepersonne) {
		this.typepersonne = typepersonne;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public String getPersonnage() {
		return this.personnage;
	}

	public void setPersonnage(String personnage) {
		this.personnage = personnage;
	}

}