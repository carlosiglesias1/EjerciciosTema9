package recursos.mobiles;

/**
 * • Crea una subclase llamada MovilPlus igual que la anterior pero que al
 * efectuar llamadas no se le aplica ningún coste por el establecimiento de
 * llamada y tiene una nueva funcionalidad llamada videollamada a la que se le
 * pasa los segundos de la videollamada y reduce el saldo de forma similar a
 * ‘navegar’. En este caso, cada segundo de llamada son 2 MB de datos (recuerda
 * que los atributos de MovilPrepago son privados, esto puede ser un problema a
 * resolver).
 */

public class MovilPlus extends MovilPrepago {
    public MovilPlus (long nM, float cML, float cMB, float saldo) {
        super(nM, 0, cML, cMB, saldo);
    }

    public MovilPlus (MovilPrepago movilPlus){
        super(movilPlus);
    }

    public void videollamada (int segundos){
        this.setSaldo(this.getSaldo()-Math.round(segundos*2*this.getCosteConsumoMB()));
        if (this.getSaldo()<0)
            this.setSaldo(0);
    }
}
