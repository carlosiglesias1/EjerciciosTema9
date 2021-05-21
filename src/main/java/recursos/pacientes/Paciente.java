package recursos.pacientes;

import java.time.LocalDate;

public abstract class Paciente {
    private String nombre;
    private LocalDate fechaNacimiento;
    public Paciente (String name, LocalDate birthDate){
        this.nombre = name;
        this.fechaNacimiento = birthDate;
    }

    public String getNombre() {
        return nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
