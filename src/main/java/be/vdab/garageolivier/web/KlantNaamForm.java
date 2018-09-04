package be.vdab.garageolivier.web;

import javax.validation.constraints.NotNull;

public class KlantNaamForm {

	@NotNull
	private String naam;

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

}
