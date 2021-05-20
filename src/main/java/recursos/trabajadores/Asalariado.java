package recursos.trabajadores;

import java.time.LocalDate;

/**• Crear una subclase de Trabajador llamada Asalariado que
 * añade un nuevo atributo llamado salarioFinal y otro llamado horasExtra. • El
 * constructor de esta nueva clase Asalariado incorpora la inicialización a cero
 * de las horas extra y el salario final igual al salario base. • La clase
 * Asalariado también incorpora setter y getter para las horas extra y un método
 * llamado calcularSalarioFinal() al que se le pasa a cuanto se paga la hora
 * extra en ese momento y calcula el salario final del empleado siendo su
 * salario base más el importe de las horas extras trabajadas. */

public class Asalariado extends Trabajador {
    private float salarioFinal;
    private int horasExtra;

    public Asalariado (String id, String nombre, LocalDate birthDate, float baseSalarial){
        super(id, nombre, birthDate, baseSalarial);
        this.horasExtra = 0;
        this.salarioFinal = 0;
    }

    public int getHorasExtra() {
        return horasExtra;
    }
    public float getSalarioFinal() {
        return salarioFinal;
    }

    public void calcularSalarioFinal(float importeHorasExtras) {
        this.salarioFinal = this.salarioBase + (this.horasExtra*importeHorasExtras);
    }
    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }
}
