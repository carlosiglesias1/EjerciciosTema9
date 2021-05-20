package recursos.pacientes;

import java.time.LocalDate;

public class PacienteRevision extends Paciente {
    private LocalDate ultimaRevision;
    public final float PRECIOMAYORES65 = 30;
    public final float PRECIOMENORES = 50;

    public PacienteRevision(String name, LocalDate birthDate, LocalDate lastMeeting) {
        super(name, birthDate);
        this.ultimaRevision = lastMeeting;
    }

    public LocalDate getUltimaRevision() {
        return ultimaRevision;
    }

    public boolean precioReducido() {
        LocalDate now = LocalDate.now();
        if (this.getFechaNacimiento().getYear() > (now.getYear() - 65)
                || this.getFechaNacimiento().getYear() == now.getYear() - 65
                        && this.getFechaNacimiento().getMonthValue() > now.getMonthValue()
                || this.getFechaNacimiento().getMonth() == now.getMonth()
                        && this.getFechaNacimiento().getDayOfMonth() > now.getDayOfMonth())
            return false;
        else
            return true;
    }
}
