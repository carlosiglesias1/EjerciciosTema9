package ejercicios;

import recursos.mobiles.*;
import java.util.Scanner;

/**
 * 9.5. Empleando las clases previas: MovilPrepago, MovilTarifaPlana, MovilPlus
 * realizar un programa que inicialmente permita seleccionar al usuario qué tipo
 * de tarifa tiene entre las tres posibles, luego configurará el móvil
 * solicitando al usuario los parámetros necesarios y finalmente presentará al
 * usuario un menú para realizar las operaciones permitidas (navegar, llamar,
 * recargar, videollamar, ver saldo y salir) según el tipo de tarifa.
 */

public class Ejercicio5 {
    static void menuMovil(MovilPrepago movilPrepago, Scanner teclado) {
        char opcion;
        do {
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
                case 'l':
                    movilPrepago.efectuarLlamada(Integer.parseInt(teclado.nextLine()));
                    break;
                case 'n':
                    movilPrepago.navegar(Integer.parseInt(teclado.nextLine()));
                    break;
                case 'r':
                    movilPrepago.recargar(Integer.parseInt(teclado.nextLine()));
                    break;
                case 's':
                    System.out.println(movilPrepago.consultarSaldo());
                    break;
                case 'v':
                    if (movilPrepago instanceof MovilPlus_v2) {
                        MovilPlus_v2 movilPlus_v2 = (MovilPlus_v2) movilPrepago;
                        movilPlus_v2.videollamada(Integer.parseInt(teclado.nextLine()));
                        movilPrepago = new MovilPrepago(movilPlus_v2);
                    }else
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
        MovilPrepago mPlus_v2 = null;
        System.out.println("Que tipo de mobil quieres?\nMovilPrepago: mp\nMovilTarifaPlana: mtp\nMobilPlus: m");
        Scanner teclado = new Scanner(System.in);
        switch (teclado.nextLine().length()) {
            case 1:
                System.out.println("Introduce un número de teléfono");
                mPlus_v2 = new MovilPlus_v2(Long.parseLong(teclado.nextLine()), CML, CMB, SALDO);
                break;
            case 2:
                System.out.println("Introduce un número de teléfono");
                mPlus_v2 = new MovilPrepago(Long.parseLong(teclado.nextLine()), CEL, CML, CMB, SALDO);
                break;
            case 3:
                System.out.println("Introduce un número de teléfono");
                mPlus_v2 = new MovilTarifaPlana(Long.parseLong(teclado.nextLine()), CEL, CML, SALDO);
                break;
            default:
                System.out.println("Error!");
                break;
        }
        if (mPlus_v2 != null)
            menuMovil(mPlus_v2, teclado);
        teclado.close();
    }
}
