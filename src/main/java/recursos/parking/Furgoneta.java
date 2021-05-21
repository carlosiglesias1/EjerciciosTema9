package recursos.parking;

public class Furgoneta extends Automobil {
    public static final float SUPLEMENTOLONGITUD = 0.2f;
    private int meters;

    public Furgoneta(String matricula, int meters) {
        super(matricula);
        this.meters = meters;
    }

    @Override
    public float parkingPrice() {
        return super.parkingPrice() + this.meters * SUPLEMENTOLONGITUD;
    }
}
