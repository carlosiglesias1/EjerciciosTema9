package recursos.cuentas;

import java.time.LocalDate;

/**
 * • Crea una clase hija llamada CuentaPlazo igual que la anterior, pero sin
 * comisiones. Además, tiene un nuevo atributo, que es la fecha de creación. •
 * Esta nueva clase ya no permitirá que haya subclases de ella. • Crea
 * constructor para la nueva clase que incorpore la inicialización de la fecha
 * de creación al día en curso. • Sobrescribe el método retirar () para que no
 * que no calcule comisiones. Revisa los modificadores de acceso de atributos y
 * quizás tengas que crear algún getter/setter.
 */

public final class CuentaPlazo extends CuentaCorriente {
    private LocalDate fechaCreacion;

    public CuentaPlazo(String IBAN) {
        super(IBAN);
        this.fechaCreacion = LocalDate.now();
        CuentaCorriente.setComision(0f, 0f);
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public boolean retirar(float importe) {
        if (importe < this.getSaldo()) {
            this.setSaldo(this.getSaldo() - importe);
            return true;
        } else
            return false;
    }
}
