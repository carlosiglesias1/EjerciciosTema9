package recursos.trabajadores;

import java.time.LocalDate;

/**
 * Crear una clase llamada Trabajador con los atributos privados: id, nombre,
 * fecha de nacimiento y salario base. • Dispondrá también de un constructor que
 * inicialice todos sus campos, getters, setters, método toString () y equals
 * (), sabiendo que dos trabajadores son iguales si tienen el mismo ‘id’.
 */

public class Trabajador {
    String id;
    String nombre;
    LocalDate fechaNacimiento;
    float salarioBase;

    public Trabajador(String id, String nombre, LocalDate birthDate, float baseSalarial) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = birthDate;
        this.salarioBase = baseSalarial;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public String toString() {
        return String.format("id: %s%nnombre: %s%nfecha de nacimiento: %s%nsalario base: %.2f", this.id, this.nombre,
                this.fechaNacimiento.toString(), this.salarioBase);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        Trabajador aux = (Trabajador) o;
        if (this.id.equals(aux.id))
            return true;
        return false;
    }
}
