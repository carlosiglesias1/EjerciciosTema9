package recursos.pacientes;

import java.time.LocalDate;

public class PacienteRevision extends Paciente{
    private LocalDate ultimaRevision;

    public PacienteRevision (String name, LocalDate birthDate, LocalDate lastMeeting){
        super(name, birthDate);
        this.ultimaRevision = lastMeeting;
    }

    public LocalDate getUltimaRevision() {
        return ultimaRevision;
    }
}
