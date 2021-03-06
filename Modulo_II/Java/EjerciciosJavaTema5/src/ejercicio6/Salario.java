package ejercicio6;

public class Salario {

    private final Double SALARIO_SERVICIO = 12000.0;
    private final Double SALARIO_PROFESOR = 22000.0;

    public Double calcularSalario(Empleado empleado){

        Double salario = 0.0;

        if(empleado instanceof PersonalServicio){
            salario = SALARIO_SERVICIO;

            String estadoCivil = empleado.getEstadoCivil();

            if(estadoCivil.equalsIgnoreCase("casado")){
                salario += (SALARIO_SERVICIO*5)/100;
            }
        }

        if(empleado instanceof Profesor){
            salario = SALARIO_PROFESOR;

            Integer anioIngreso = empleado.getAnioIngreso();
            if(anioIngreso < 2000){
                salario += (SALARIO_PROFESOR*8)/100;
            }
        }
        return salario;
    }

}
