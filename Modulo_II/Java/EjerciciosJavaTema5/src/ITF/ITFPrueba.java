package ITF;

import java.util.ArrayList;

public class ITFPrueba {

	/*public static void main(String[] args) {
		
		ITFImpresion itfpositivo = null;
		ITFImpresion itfnegativo = null;
		
		ArrayList<ITFImpresion> imp= new ArrayList<ITFImpresion>();
		
		imp.add(itfpositivo);
		imp.add(itfnegativo);

		for (ITFImpresion imprime : imp) {
			imprime.imprimir();
		}
	}*/

	public static void main(String[] args){

        ArrayList<ITFImpresion> lista = new ArrayList<>();

        ITFImpresion impresionPositiva = new ITFPositivo();
        ITFImpresion impresionNegativa = new ITFNegativo();

        lista.add(impresionPositiva);
        lista.add(impresionNegativa);

        for (ITFImpresion impresion : lista) {
            System.out.println(impresion.imprimir());
        }
    }
}
