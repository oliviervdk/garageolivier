package be.vdab.garageolivier.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;

import be.vdab.garageolivier.valueobjects.Adres;

@Entity
@Table(name = "klanten")
public class Klant implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long klantId;
	@NotBlank
	@Length(min = 1, max = 50)
	@SafeHtml
	private String voornaam;
	@NotBlank
	@Length(min = 1, max = 50)
	@SafeHtml
	private String familienaam;
	@Valid
	@Embedded
	private Adres adres;
	@Version
	private long versie;

	public Klant() {
	}

	public Klant(String voornaam, String familienaam, Adres adres) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.adres = adres;
	}

	public Klant(long klantId, String voornaam, String familienaam, Adres adres) {
		this(voornaam, familienaam, adres);
		this.klantId = klantId;
	}

	public long getKlantId() {
		return klantId;
	}

	public void setKlantId(long klantId) {
		this.klantId = klantId;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public String getNaam() {
		return voornaam + " " + familienaam;
	}

	public long getVersie() {
		return versie;
	}

	public void setVersie(long versie) {
		this.versie = versie;
	}


}
