package recursos.trabajadores;

import java.time.LocalDate;

/**
 * • Crear una subclase de Trabajador llamada ConsultorExterno que añade un
 * nuevo atributo llamado horasTrabajadas y salarioFinal. • El constructor de
 * esta nueva clase ConsultorExterno incorpora la inicialización a cero de las
 * horas trabajadas, salario base y salario final. • La clase ConsultorExterno
 * también incorpora setter y getter para las horas trabajadas y un método
 * llamado calcularSalarioFinal() al que se le pasa a cuanto se paga la hora a
 * los consultores en ese momento y calcula el salario final del consultor solo
 * en función de las horas trabajadas (el salario base de estos trabajadores es
 * cero).
 */

public class ConsultorExterno extends Trabajador {
    private int horasTrabajadas;
    private float salarioFinal;

    public ConsultorExterno(String id, String nombre, LocalDate birthDate) {
        super(id, nombre, birthDate, 0f);
        this.horasTrabajadas = 0;
        this.salarioFinal = 0f;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public float getSalarioFinal() {
        return salarioFinal;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public void calcularSalarioFinal(float precioHoraConsultor) {
        this.salarioFinal = this.horasTrabajadas * precioHoraConsultor;
    }
}
