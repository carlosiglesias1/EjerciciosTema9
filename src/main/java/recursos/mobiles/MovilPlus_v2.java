package recursos.mobiles;

public class MovilPlus_v2 extends MovilPrepago {
    public MovilPlus_v2 (long nM, float cML, float cMB, float saldo) {
        super(nM, 0, cML, cMB, saldo);
    }

    public MovilPlus_v2 (MovilPrepago movilPlus){
        super(movilPlus);
    }

    public void videollamada (int segundos){
        this.setSaldo(this.getSaldo()-Math.round(segundos*2*this.getCosteConsumoMB()));
        if (this.getSaldo()<0)
            this.setSaldo(0);
    }

    @Override
    public boolean equals (Object object){
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (object instanceof MovilPlus_v2 == false)
            return false;
        MovilPlus_v2 aux = (MovilPlus_v2) object;
        if (this.numeroMovil == aux.numeroMovil)
            return true;
        return false;
    }
}
