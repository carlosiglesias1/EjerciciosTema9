package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;
import recursos.cuentas.*;

/**
 * 9.11. Partiendo de clases del ejercicio 8.9 (CuentaCorriente, CuentaPlazo),
 * haz un programa con un menú que permita gestionar unas cuentas bancarias que
 * se almacenan en un ArrayList (añadir cuenta, eliminar cuenta, ingresos y,
 * retiradas) siempre accediendo por un identificador que tendrá cada cuenta.
 */

public class Ejercicio11 {
    static void prompt() {
        System.out.println("i: ingresar\nr: retirar\nv: ver saldo\ne: salir");
    }

    public static void main(String[] args) {
        final String PROMPTCUENTA = "Sobre qué cuenta quieres operar?";
        ArrayList<CuentaCorriente> cuentaCorrientes = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        char opcion;
        do {
            System.out.println(
                    "Crea una nueva cuenta\n\tcc: CuentaCorriente\n\tcp: CuentaPlazo\n\tsalir: finalizas de crear cunetas");
            opcion = teclado.nextLine().charAt(1);
            switch (opcion) {
                case 'a':
                    break;
                case 'c':
                    System.out.println("Introduce un ivan");
                    cuentaCorrientes.add(new CuentaCorriente(teclado.nextLine()));
                    break;
                case 'p':
                    System.out.println("Introduce un ivan");
                    cuentaCorrientes.add(new CuentaPlazo(teclado.nextLine()));
                    break;
                default:
                    System.out.println("La has cagau");
                    break;
            }
        } while (opcion != 'a');
        do {
            prompt();
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
                case 'i':
                    System.out.println("Ingresar dinero: ");
                    System.out.println(PROMPTCUENTA);
                    cuentaCorrientes.get(Integer.parseInt(teclado.nextLine()))
                            .ingresar(Float.parseFloat(teclado.nextLine()));
                    break;
                case 'r':
                    System.out.println("Retirar dinero: ");
                    System.out.println(PROMPTCUENTA);
                    if (cuentaCorrientes.get(Integer.parseInt(teclado.nextLine()))
                            .retirar(Float.parseFloat(teclado.nextLine())))
                        System.out.println("Recoja su dinero");
                    else
                        System.out.println("No se ha podido realizar la operacion");
                    break;
                case 'v':
                    System.out.println(PROMPTCUENTA);
                    System.out.println(cuentaCorrientes.get(Integer.parseInt(teclado.nextLine())).getSaldo());
                    break;
                case 'e':
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (opcion != 'e');
        teclado.close();
    }
}
