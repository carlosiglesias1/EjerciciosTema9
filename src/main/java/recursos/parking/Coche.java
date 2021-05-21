package recursos.parking;

public class Coche extends Automobil{
    
    public Coche (String matricula){
        super(matricula);
    }

    @Override
    public float parkingPrice (){
        return super.parkingPrice();
    }
}
