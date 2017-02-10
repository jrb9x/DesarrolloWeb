package ArrayList;

public class Empleado {

	private String nif;
	private double sueldoBase;
	private double pagoHoraExtra;
	private int horaExtraMes;
	private double irpf;
	private int numHijos;
	
	public Empleado(){
		
	}
	
	public Empleado(String nif, double sueldoBase, double pagoHoraExtra, int horaExtraMes, double irpf, int numHijos) {
		this.nif = nif;
		this.sueldoBase = sueldoBase;
		this.pagoHoraExtra = pagoHoraExtra;
		this.horaExtraMes = horaExtraMes;
		this.irpf = irpf;
		this.numHijos = numHijos;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public double getPagoHoraExtra() {
		return pagoHoraExtra;
	}

	public void setPagoHoraExtra(double pagoHoraExtra) {
		this.pagoHoraExtra = pagoHoraExtra;
	}

	public int getHoraExtraMes() {
		return horaExtraMes;
	}

	public void setHoraExtraMes(int horaExtraMes) {
		this.horaExtraMes = horaExtraMes;
	}

	public double getIrpf() {
		return irpf;
	}

	public void setIrpf(double irpf) {
		this.irpf = irpf;
	}

	public int getNumHijos() {
		return numHijos;
	}

	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}
	
	public double calculoComplementoHorasExtra(){
		return pagoHoraExtra*horaExtraMes;
	}
	
	public double sueldoBruto(){
		return sueldoBase + calculoComplementoHorasExtra();
	}
	
	public double retenciones(){
		switch(numHijos){
		case 0:
			return sueldoBruto()*(irpf/100);
		case 1:
		case 2:
			return sueldoBruto()*((irpf-1)/100);
		default:
			return sueldoBruto()*((irpf-2)/100);
		}
	}

	@Override
	public String toString() {
		return "Empleado [ nif=" + nif + ", sueldoBase=" + sueldoBase + ", pagoHoraExtra=" + pagoHoraExtra
				+ ", horaExtraMes=" + horaExtraMes + ", irpf=" + irpf + ", numHijos=" + numHijos + "]";
	}
	
}
