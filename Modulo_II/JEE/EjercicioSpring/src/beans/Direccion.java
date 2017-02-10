package beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Direccion implements Serializable {

	private String cp;
	private String calle;
	
	public Direccion() {
		super();
	}
	

	public Direccion(String cp, String calle) {
		super();
		this.cp = cp;
		this.calle = calle;
	}


	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this); 
	}
	
	
	
}
