package ejercicios;

import recursos.mobiles.MovilPlus_v2;
import recursos.mobiles.MovilPrepago;
import recursos.mobiles.MovilTarifaPlana;

import java.util.Scanner;

/**
 * 9.6. Modificar el programa anterior para que el usuario tenga un Array de 5
 * teléfonos, y que después de elegir la operación a realizar pueda elegir con
 * cuál de los 5 teléfonos desea hacerla
 */

public class Ejercicio6 {
    static void menuMovil(MovilPrepago[] movilPrepago, Scanner teclado) {
        char opcion;
        do {
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
                case 'l':
                    System.out.println("Con cuál de los 5 teléfonos quieres llamar?");
                    movilPrepago[Integer.parseInt(teclado.nextLine())]
                            .efectuarLlamada(Integer.parseInt(teclado.nextLine()));
                    break;
                case 'n':
                    System.out.println("Con cuál de los 5 teléfonos quieres navegar?");
                    movilPrepago[Integer.parseInt(teclado.nextLine())].navegar(Integer.parseInt(teclado.nextLine()));
                    break;
                case 'r':
                    System.out.println("Con cuál de los 5 teléfonos quieres recargar?");
                    movilPrepago[Integer.parseInt(teclado.nextLine())].recargar(Integer.parseInt(teclado.nextLine()));
                    break;
                case 's':
                    System.out.println("Con cuál de los 5 teléfonos quieres consultar el saldo?");
                    System.out.println(movilPrepago[Integer.parseInt(teclado.nextLine())].consultarSaldo());
                    break;
                case 'v':
                    System.out.println("Con cuál de los 5 teléfonos quieres videollamar?");
                    int i = Integer.parseInt(teclado.nextLine());
                    if (movilPrepago[i] instanceof MovilPlus_v2) {
                        MovilPlus_v2 movilPlus_v2 = (MovilPlus_v2) movilPrepago[i];
                        movilPlus_v2.videollamada(Integer.parseInt(teclado.nextLine()));
                        movilPrepago[i] = new MovilPlus_v2(movilPlus_v2);
                    } else
                        System.out.println("Introduce un móbil válido");
                    break;
                default:
                    opcion = 'e';
                    break;
            }
        } while (opcion != 'e');
    }

    public static void main(String[] args) {
        final float CEL = 0.21f;
        final float CML = 0.51f;
        final float CMB = 0.07f;
        final float SALDO = 10f;
        MovilPrepago[] mPlus_v2 = new MovilPrepago[5];
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < mPlus_v2.length; i++) {
            System.out.println("Que tipo de mobil quieres?\nMovilPrepago: mp\nMovilTarifaPlana: mtp\nMobilPlus: m");
            switch (teclado.nextLine().length()) {
                case 1:
                    System.out.println("Introduce un número de teléfono");
                    mPlus_v2[i] = new MovilPlus_v2(Long.parseLong(teclado.nextLine()), CML, CMB, SALDO);
                    break;
                case 2:
                    System.out.println("Introduce un número de teléfono");
                    mPlus_v2[i] = new MovilPrepago(Long.parseLong(teclado.nextLine()), CEL, CML, CMB, SALDO);
                    break;
                case 3:
                    System.out.println("Introduce un número de teléfono");
                    mPlus_v2[i] = new MovilTarifaPlana(Long.parseLong(teclado.nextLine()), CEL, CML, SALDO);
                    break;
                default:
                    System.out.println("Error!");
                    break;
            }
        }
        if (mPlus_v2 != null)
            menuMovil(mPlus_v2, teclado);
        teclado.close();
    }
}
