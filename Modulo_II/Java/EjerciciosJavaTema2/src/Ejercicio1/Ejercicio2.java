package Ejercicio1;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		int D = 0, M = 0, A = 0, finalMes = 0;
		
		try{
			D = new Integer(args[0]);
			M = new Integer(args[1]);
			A = new Integer(args[2]);
		}
		catch(Exception e){
			System.out.println("Introducir datos correctamente!");
			System.exit(0);
		}
		
		switch (M) {
		case 4:
		case 6:
		case 9:
		case 11: finalMes = 30;
			if(D < finalMes)
				D++;
			else{
				D = 1;
				M++;
			}
		break;
		case 2:if ((A % 4 == 0) && ((A % 100 != 0) || (A % 400 == 0))) 
			finalMes = 29;
		else
			finalMes = 28;
				if(D < finalMes)
					D++;
				else{
					D = 1;
					M++;
				}
		break;
		default: finalMes = 31;
				if(D < finalMes)
					D++;
				else{
					if(M == 12){
						A++;
						M = 1;
						D = 1;
					}
					else{
						D = 1;
						M++;
					}
				}
		break;
		}
		
		System.out.println("Mañana es dia : " + D + "/"+ M + "/" + A);
			
	}

}
