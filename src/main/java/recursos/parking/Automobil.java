package recursos.parking;

import java.time.LocalDate;
import java.time.LocalTime;

public class Automobil {
    public static final float PARKPRICE = 0.04f;
    private String matricula;
    private LocalDate fechaEntrada;
    private LocalTime horaEntrada;

    public Automobil(String matricula) {
        this.matricula = matricula;
        this.fechaEntrada = LocalDate.now();
        this.horaEntrada = LocalTime.now();
    }

    public String getMatricula() {
        return matricula;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public float parkingPrice() {
        int minutes = (LocalTime.now().getHour()*60 + LocalTime.now().getMinute())
                - (this.horaEntrada.getHour() * 60 + this.horaEntrada.getMinute());
        return minutes * PARKPRICE;
    }

    @Override
    public String toString() {
        return "[" + this.matricula + "," + this.fechaEntrada + "//" + this.horaEntrada + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object instanceof Automobil) {
            Automobil automobil = (Automobil) object;
            if (this.matricula.equals(automobil.matricula))
                return true;
        }
        return false;
    }
}
