package be.vdab.garageolivier.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import org.hibernate.validator.constraints.SafeHtml;

@Entity
@Table(name = "autos")
public class Auto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long autoId;
	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 50)
	private String merk;
	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 50)
	private String type;
	@NotNull
	@Min(1900)
	private int bouwjaar;
	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 50)
	private String nummerplaat;
	@ManyToOne(optional = false)
	@JoinColumn(name = "klanten_klantid")
	private Klant klant;
	@Version
	private long versie;
	
	
	public Auto() {}
	public Auto(String merk, String type, int bouwjaar, String nummerplaat, Klant klant) {
		this.merk = merk;
		this.type = type;
		this.bouwjaar = bouwjaar;
		this.nummerplaat = nummerplaat.toUpperCase();
		this.klant = klant;
	}
	public Auto(long autoid, String merk, String type, int bouwjaar, String nummerplaat, Klant klant) {
		this(merk, type, bouwjaar, nummerplaat, klant);
		this.autoId = autoid;
	}
	
	public long getAutoId() {
		return autoId;
	}
	public void setAutoId(long autoId) {
		this.autoId = autoId;
	}
	public String getMerk() {
		return merk;
	}

	public void setMerk(String merk) {
		this.merk = merk;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBouwjaar() {
		return bouwjaar;
	}

	public void setBouwjaar(int bouwjaar) {
		this.bouwjaar = bouwjaar;
	}

	public String getNummerplaat() {
		return nummerplaat;
	}

	public void setNummerplaat(String nummerplaat) {
		this.nummerplaat = nummerplaat.toUpperCase();
	}

	public Klant getKlant() {
		return klant;
	}

	public void setKlant(Klant klant) {
		this.klant = klant;
	}
	
	public long getVersie() {
		return versie;
	}
	public void setVersie(long versie) {
		this.versie = versie;
	}
	public String getNaam() {
		return nummerplaat + ", " + merk  + ", " + type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nummerplaat == null) ? 0 : nummerplaat.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		if (nummerplaat == null) {
			if (other.nummerplaat != null)
				return false;
		} else if (!nummerplaat.equals(other.nummerplaat))
			return false;
		return true;
	}
}
