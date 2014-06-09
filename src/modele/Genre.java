package modele;

// Generated Jun 9, 2014 4:05:17 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Genre generated by hbm2java
 */
public class Genre implements java.io.Serializable {

	private BigDecimal idgenre;
	private String libellegenre;
	private Set films = new HashSet(0);

	public Genre() {
	}

	public Genre(BigDecimal idgenre, String libellegenre) {
		this.idgenre = idgenre;
		this.libellegenre = libellegenre;
	}

	public Genre(BigDecimal idgenre, String libellegenre, Set films) {
		this.idgenre = idgenre;
		this.libellegenre = libellegenre;
		this.films = films;
	}

	public BigDecimal getIdgenre() {
		return this.idgenre;
	}

	public void setIdgenre(BigDecimal idgenre) {
		this.idgenre = idgenre;
	}

	public String getLibellegenre() {
		return this.libellegenre;
	}

	public void setLibellegenre(String libellegenre) {
		this.libellegenre = libellegenre;
	}

	public Set getFilms() {
		return this.films;
	}

	public void setFilms(Set films) {
		this.films = films;
	}

}