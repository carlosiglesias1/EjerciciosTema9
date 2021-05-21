package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

import recursos.figuras.*;

/**
 * 9.2. Realiza un programa que permita al usuario seleccionar un tipo de figura
 * (Triangulo o Rectangulo), luego llame al constructor adecuado solicitando al
 * usuario los parámetros necesarios, dependiendo del tipo de figura. • Después
 * de crear la figura, mostrará las dimensiones de la misma (sea cual sea su
 * tipo). • Finalmente, y utilizando el operador instanceof, mostrará unos datos
 * adicionales dependiendo del tipo de figura que sea: - Si es de tipo
 * Triangulo, mostrará el área. - Si es de tipo Rectangulo, mostrará si es de
 * forma cuadrada o no. • Usar una única variable para almacenar la figura, sea
 * del tipo que sea.
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        ArrayList<Figura2D_v8> figuraList = new ArrayList<>();
        char opcion;
        Scanner teclado = new Scanner(System.in);
        do {
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
                case 't':
                    figuraList.add(new Triangulo_v8(Float.parseFloat(teclado.nextLine()), "rectángulo"));
                    break;
                case 'r':
                    figuraList.add(new Rectangulo_v8(Float.parseFloat(teclado.nextLine()),
                            Float.parseFloat(teclado.nextLine()), "rectángulo"));
                    break;
                default:
                    figuraList.add(new Figura2D_v8());
                    break;
            }
        } while (opcion != 's');
        for (Figura2D_v8 figura2d_v8 : figuraList) {
            if (figura2d_v8 instanceof Triangulo_v8) {
                Triangulo_v8 triangulo_v8 = (Triangulo_v8) figura2d_v8;
                System.out.println(triangulo_v8.area());
            } else if (figura2d_v8 instanceof Rectangulo_v8) {
                Rectangulo_v8 rectangulo_v8 = (Rectangulo_v8) figura2d_v8;
                if (rectangulo_v8.esCuadrado()) {
                    System.out.println("Es cuadrado");
                } else {
                    System.out.println("No es cuadrado");
                }
            }
        }
        teclado.close();
    }
}
