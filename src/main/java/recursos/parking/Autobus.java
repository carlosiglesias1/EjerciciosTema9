package recursos.parking;

public class Autobus extends Automobil{
    
    public static final float SUPLEMENTOSEATS = 0.25f;
    private int seats;

    public Autobus (String matricula, int seats){
        super(matricula);
        this.seats = seats;
    }

    @Override
    public float parkingPrice (){
        return super.parkingPrice()+this.seats*SUPLEMENTOSEATS;
    }
}
