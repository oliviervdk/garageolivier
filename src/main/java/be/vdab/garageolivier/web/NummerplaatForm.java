package be.vdab.garageolivier.web;

import javax.validation.constraints.NotNull;

public class NummerplaatForm {

	@NotNull
	private String nummerplaat;

	public String getNummerplaat() {
		return nummerplaat;
	}

	public void setNummerplaat(String nummerplaat) {
		this.nummerplaat = nummerplaat;
	}

}
