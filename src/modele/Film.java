package modele;

// Generated Jun 9, 2014 4:05:17 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Film generated by hbm2java
 */
public class Film implements java.io.Serializable {

	private BigDecimal idfilm;
	private String titre;
	private short anneesortie;
	private String langue;
	private BigDecimal duree;
	private String resume;
	private String image;
	private Set payses = new HashSet(0);
	private Set genres = new HashSet(0);
	private Set annonces = new HashSet(0);
	private Set implications = new HashSet(0);
	private Set exemplaires = new HashSet(0);

	public Film() {
	}

	public Film(BigDecimal idfilm, String titre, short anneesortie,
			BigDecimal duree, String resume) {
		this.idfilm = idfilm;
		this.titre = titre;
		this.anneesortie = anneesortie;
		this.duree = duree;
		this.resume = resume;
	}

	public Film(BigDecimal idfilm, String titre, short anneesortie,
			String langue, BigDecimal duree, String resume, String image,
			Set payses, Set genres, Set annonces, Set implications,
			Set exemplaires) {
		this.idfilm = idfilm;
		this.titre = titre;
		this.anneesortie = anneesortie;
		this.langue = langue;
		this.duree = duree;
		this.resume = resume;
		this.image = image;
		this.payses = payses;
		this.genres = genres;
		this.annonces = annonces;
		this.implications = implications;
		this.exemplaires = exemplaires;
	}

	public BigDecimal getIdfilm() {
		return this.idfilm;
	}

	public void setIdfilm(BigDecimal idfilm) {
		this.idfilm = idfilm;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public short getAnneesortie() {
		return this.anneesortie;
	}

	public void setAnneesortie(short anneesortie) {
		this.anneesortie = anneesortie;
	}

	public String getLangue() {
		return this.langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public BigDecimal getDuree() {
		return this.duree;
	}

	public void setDuree(BigDecimal duree) {
		this.duree = duree;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set getPayses() {
		return this.payses;
	}

	public void setPayses(Set payses) {
		this.payses = payses;
	}

	public Set getGenres() {
		return this.genres;
	}

	public void setGenres(Set genres) {
		this.genres = genres;
	}

	public Set getAnnonces() {
		return this.annonces;
	}

	public void setAnnonces(Set annonces) {
		this.annonces = annonces;
	}

	public Set getImplications() {
		return this.implications;
	}

	public void setImplications(Set implications) {
		this.implications = implications;
	}

	public Set getExemplaires() {
		return this.exemplaires;
	}

	public void setExemplaires(Set exemplaires) {
		this.exemplaires = exemplaires;
	}

}