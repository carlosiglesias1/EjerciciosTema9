package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

import recursos.figuras.*;

/**
 * 9.3. Modificar el ejercicio anterior para añadir a las figuras posibles el
 * Triancolor. Así pues, el usuario seleccionará entre: Triangulo, Triancolor,
 * Rectangulo. • Después de crear la figura, mostrará las dimensiones de la
 * misma (sea cual sea su tipo). • Finalmente, y utilizando el operador
 * instanceof, mostrará unos datos adicionales dependiendo del tipo de figura
 * que sea: - Si es de tipo Triangulo, mostrará el área (sea Triancolor o no). -
 * Si es de tipo Rectangulo, mostrará si es de forma cuadrada o no. - Si es de
 * tipo Triancolor, mostrará el color
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        ArrayList<Figura2D_v8> figuraList = new ArrayList<Figura2D_v8>();
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
                case 'c':
                    figuraList.add(new TrianColor_v6(Float.parseFloat(teclado.nextLine()),
                            Float.parseFloat(teclado.nextLine()), "TrianColor", "Unknown", teclado.nextLine()));
                    break;
                default:
                    figuraList.add(new Figura2D_v8());
                    break;
            }
        } while (opcion != 's');
        for (Figura2D_v8 figura2d_v8 : figuraList) {
            if (figura2d_v8 instanceof Triangulo_v8) {
                if (figura2d_v8 instanceof TrianColor_v6) {
                    TrianColor_v6 trianColor_v6 = (TrianColor_v6) figura2d_v8;
                    System.out.println(trianColor_v6.getColor());
                } else {
                    Triangulo_v8 triangulo_v8 = (Triangulo_v8) figura2d_v8;
                    System.out.println(triangulo_v8.area());
                }
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
