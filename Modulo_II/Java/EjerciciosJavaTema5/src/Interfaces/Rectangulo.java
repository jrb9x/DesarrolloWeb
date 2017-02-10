package Interfaces;

public class Rectangulo implements Imprimible,Detallable{
	Punto arribaIzq, arribaDrch, abajoIzq, abajoDrch;
	float base, altura;
	
	
	public Rectangulo(Punto arribaIzq, Punto arribaDrch, Punto abajoIzq, Punto abajoDrch) {
		this.arribaIzq = arribaIzq;
		this.arribaDrch = arribaDrch;
		this.abajoIzq = abajoIzq;
		this.abajoDrch = abajoDrch;
		base = abajoDrch.getX()-abajoIzq.getX();
		altura=arribaDrch.getY()-abajoIzq.getY();
	}
	public Rectangulo(Punto arribaIzq, Punto arribaDrch, Punto abajoDrch){
		this.arribaIzq=arribaIzq;
		this.arribaDrch=arribaDrch;
		this.abajoIzq=new Punto(0,0);
		this.abajoDrch=abajoDrch;
		base = abajoDrch.getX()-abajoIzq.getX();
		altura=arribaDrch.getY()-abajoIzq.getY();
	}
	
	public double area(){
		return base*altura;
	}

	@Override
	public void imprimir() {
		for (int i = 0; i <altura ; i++) {
			for(int j=0; j<base ;j++){
				if(i==0||i==altura-1){
					System.out.print("* ");
				}else{
					if(j==0||j==base-1){
						System.out.print("* ");
					}else{
						System.out.print("  ");
					}
				}
				
			}
			System.out.print("\n");
		}
		
	}
	@Override
	public void mostrarDetalle() {
		System.out.println(" La base del rectangulo es"+base+" y su altura ="+altura);
		
	}
	
}
