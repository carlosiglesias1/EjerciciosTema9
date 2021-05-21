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
    static void prompt (){
        System.out.println("i: ingresar\nr: retirar\nv: ver saldo\ne: salir");
    }
    public static void main(String[] args) {
        ArrayList <CuentaCorriente> cuentaCorrientes = new ArrayList<CuentaCorriente>();
        Scanner teclado = new Scanner(System.in);
        char opcion;
        System.out.println("Crea una nueva cuenta");
        cPlazo = new CuentaPlazo(teclado.nextLine());
        do {
            prompt();
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
                case 'i':
                    System.out.println("Ingresar dinero: ");
                    cPlazo.ingresar(Float.parseFloat(teclado.nextLine()));
                    break;
                case 'r':
                    System.out.println("Retirar dinero: ");
                    if(cPlazo.retirar(Float.parseFloat(teclado.nextLine())))
                        System.out.println("Recoja su dinero");
                    else
                        System.out.println("No se ha podido realizar la operacion");
                    break;
                case 'v':
                    System.out.println(cPlazo.getSaldo());
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
