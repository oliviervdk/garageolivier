package be.vdab.garageolivier.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "herstellingen")
@NamedEntityGraph(name = "Herstelling.metTechnieker",
	attributeNodes = @NamedAttributeNode("techniekers"))
public class Herstelling implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long herstellingId;
	@NotNull
	private LocalDate herstelDatum;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "autos_autoid")
	private Auto auto;
	@ManyToMany
	@JoinTable(name = "techniekers_herstellingen", joinColumns = @JoinColumn(name = "herstellingen_herstellingid"), inverseJoinColumns = @JoinColumn(name = "techniekers_techniekerid"))
	private List<Technieker> techniekers;
	@NotNull
	@NumberFormat(style = Style.NUMBER)
	private int aantalUren;
	@Version
	private long versie;

	public Herstelling() {
	}

	public Herstelling(LocalDate herstelDatum, Auto auto, List<Technieker> techniekers, int aantalUren) {
		this.herstelDatum = herstelDatum;
		this.auto = auto;
		this.techniekers = techniekers;
		this.aantalUren = aantalUren;
	}

	public Herstelling(long herstellingid, LocalDate herstelDatum, Auto auto, List<Technieker> techniekers,
			int aantalUren) {
		this(herstelDatum, auto, techniekers, aantalUren);
		this.herstellingId = herstellingid;
	}

	@DateTimeFormat(style = "L-")
	public LocalDate getHerstelDatum() {
		return herstelDatum;
	}

	public void setHerstelDatum(LocalDate herstelDatum) {
		this.herstelDatum = herstelDatum;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public List<Technieker> getTechniekers() {
		return techniekers;
	}

	public void setTechniekers(List<Technieker> techniekers) {
		this.techniekers = techniekers;
	}

	public int getAantalUren() {
		return aantalUren;
	}

	public void setAantalUren(int aantalUren) {
		this.aantalUren = aantalUren;
	}

	public long getVersie() {
		return versie;
	}

	public void setVersie(long versie) {
		this.versie = versie;
	}

	@DateTimeFormat(iso = ISO.DATE)
	public LocalDate getHerstelDatumForm() {
		return herstelDatum;
	}

	public void setHerstelDatumForm(LocalDate herstelDatumForm) {
		this.herstelDatum = herstelDatumForm;
	}

}
