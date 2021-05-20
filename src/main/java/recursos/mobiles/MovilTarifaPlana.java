package recursos.mobiles;

/**
 * Añade una nueva subclase de MovilPrepago llamada MovilTarifaPlana¸ en la que
 * se redefine el método navegar para no reducir el saldo y además en el
 * constructor fija el coste de navegación a cero.
 */

public class MovilTarifaPlana extends MovilPrepago {
    public MovilTarifaPlana (long nM, float cEL, float cML, float s){
        super(nM, cEL, cML, 0, s);
    }

    public void navegar (int mb) {
        //empty method
  }
}
