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
@Table(name = "techniekers")
public class Technieker implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long techniekerId;
	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 50)
	private String voornaam;
	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 50)
	private String familienaam;
	@Valid
	@Embedded
	private Adres adres;
	@Version
	private long versie;
	
	public Technieker() {}
	public Technieker(String voornaam, String familienaam, Adres adres) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.adres = adres;
	}
	public Technieker(long techniekerId, String voornaam, String familienaam, Adres adres) {
		this(voornaam, familienaam, adres);
		this.techniekerId = techniekerId;
	}
	
	public long getId() {
		return techniekerId;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public String getFamilienaam() {
		return familienaam;
	}
	public Adres getAdres() {
		return adres;
	}
	public void setId(long techniekerId) {
		this.techniekerId = techniekerId;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
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
