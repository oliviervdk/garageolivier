package be.vdab.garageolivier.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
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
	
	public Klant() {}
	public Klant(String voornaam, String familienaam, Adres adres) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.adres = adres;
	}
	public Klant(long klantId, String voornaam, String familienaam, Adres adres) {
		this(voornaam, familienaam, adres);
		this.klantId = klantId;
	}

	public long getId() {
		return klantId;
	}
	
	public void setId(long klantId) {
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
}
