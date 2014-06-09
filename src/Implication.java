// default package
// Generated 2014-06-09 11:13:01 by Hibernate Tools 4.0.0

/**
 * Implication generated by hbm2java
 */
public class Implication implements java.io.Serializable {

	private ImplicationId id;
	private Typepersonne typepersonne;
	private Personne personne;
	private Film film;
	private String personnage;

	public Implication() {
	}

	public Implication(ImplicationId id, Typepersonne typepersonne,
			Personne personne, Film film) {
		this.id = id;
		this.typepersonne = typepersonne;
		this.personne = personne;
		this.film = film;
	}

	public Implication(ImplicationId id, Typepersonne typepersonne,
			Personne personne, Film film, String personnage) {
		this.id = id;
		this.typepersonne = typepersonne;
		this.personne = personne;
		this.film = film;
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

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public String getPersonnage() {
		return this.personnage;
	}

	public void setPersonnage(String personnage) {
		this.personnage = personnage;
	}

}
