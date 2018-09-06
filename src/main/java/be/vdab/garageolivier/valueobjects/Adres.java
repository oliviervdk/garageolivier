package be.vdab.garageolivier.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;

@Embeddable
public class Adres implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank
	@Length(min = 1, max = 50)
	@SafeHtml
	private String straat;
	@NotBlank
	@Length(min = 1, max = 7)
	@SafeHtml
	private String huisNr;
	@NotNull
	@Range(min=1000, max=9999)
	private Integer postcode;
	@NotBlank
	@Length(min = 1, max = 50)
	@SafeHtml
	private String gemeente;

	public Adres() {}
	public Adres(String straat, String huisNr, Integer postcode, String gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	public String getStraat() {
		return straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public String getGemeente() {
		return gemeente;
	}
	
}
