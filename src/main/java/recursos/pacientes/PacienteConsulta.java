package recursos.pacientes;

import java.time.LocalDate;

public class PacienteConsulta extends Paciente{
    
    private String motivoConsulta;
    public static final float PRECIOCONSULTA = 100;

    public PacienteConsulta (String name, LocalDate birthDate, String meetingReason){
        super(name, birthDate);
        this.motivoConsulta = meetingReason;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }
}
