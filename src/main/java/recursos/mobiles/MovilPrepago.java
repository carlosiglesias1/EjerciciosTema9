package recursos.mobiles;

public class MovilPrepago {
    public long numeroMovil;
    private float costeEstablecLlamada;
    private float costeMinutoLlamada ;
    private float costeConsumoMB;
    private float saldo;

public MovilPrepago (long nM, float cEL, float cML, float cMB, float s) {
    numeroMovil = nM;
    costeEstablecLlamada = cEL;
    costeMinutoLlamada = cML;
    costeConsumoMB = cMB;
    saldo =s;
}

public MovilPrepago (MovilPrepago movilPrepago){
      this.numeroMovil = movilPrepago.numeroMovil;
      this.costeEstablecLlamada = movilPrepago.costeEstablecLlamada;
      this.costeMinutoLlamada = movilPrepago.costeMinutoLlamada;
      this.costeConsumoMB = movilPrepago.costeConsumoMB;
      this.saldo = movilPrepago.getSaldo();
}

public float getCosteConsumoMB() {
    return costeConsumoMB;
}

public float getSaldo() {
    return saldo;
}

public void setSaldo(float saldo) {
    this.saldo = saldo;
}

public void efectuarLlamada (int segundos) {
      saldo  -= Math.round((costeEstablecLlamada +
                            costeMinutoLlamada /60f * segundos) * 100f)/100f; 
      if (saldo < 0) saldo = 0;
}
public void navegar (int mb) {
      saldo -= Math.round(costeConsumoMB* mb * 100f) / 100f;
      if (saldo < 0) saldo = 0;
}
public boolean recargar (int importe) {
      if (importe % 5 == 0) {
         saldo += importe;
         return true;
      }
      else return false;
}
public float consultarSaldo () {
      return saldo;
}

@Override
public String toString (){
      return String.format("Número de móvil: %d%nSaldo: %.2f", this.numeroMovil, this.saldo);
}

} //fin clase