package ejercicios;

import recursos.figuras.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 9.4. Realiza un programa que contenga un ArrayList de figuras2D de cualquiera
 * de sus tipos e introduce valores “a mano”, por ejemplo, un par de instancias
 * de cada tipo. A continuación, el programa: • Sumar el área de todas ellas.
 * ¿Tienen implementado el método área () todas ellas? • Contar cuantos
 * triángulos (sean de color o no) y cuantos rectángulos.
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        ArrayList<Figura2D_v8> figurasList = new ArrayList<Figura2D_v8>();
        Scanner teclado = new Scanner(System.in);
        char opcion;
        float areaTotal = 0;
        float totalTriangulos = 0;
        float totalRectangulos = 0;
        do {
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
                case 't':
                    figurasList.add(new Triangulo_v8(Float.parseFloat(teclado.nextLine()), "rectángulo"));
                    break;
                case 'r':
                    figurasList.add(new Rectangulo_v8(Float.parseFloat(teclado.nextLine()),
                            Float.parseFloat(teclado.nextLine()), "rectángulo"));
                    break;
                case 'c':
                    figurasList.add(new TrianColor_v6(Float.parseFloat(teclado.nextLine()),
                            Float.parseFloat(teclado.nextLine()), "TrianColor", "Unknown", teclado.nextLine()));
                    break;
                default:
                    figurasList.add(new Figura2D_v8());
                    break;
            }
        } while (opcion != 's');
        for (Figura2D_v8 figura2d_v8 : figurasList) {
            if (figura2d_v8 instanceof Triangulo_v8) {
                Triangulo_v8 triangulo_v8 = (Triangulo_v8) figura2d_v8;
                areaTotal += triangulo_v8.area();
                totalTriangulos++;
            } else if (figura2d_v8 instanceof Rectangulo_v8) {
                Rectangulo_v8 rectangulo_v8 = (Rectangulo_v8) figura2d_v8;
                areaTotal += rectangulo_v8.getAlto()*rectangulo_v8.getAncho();
                totalRectangulos++;
            }
        }
        System.out.println(areaTotal+"\n");
        System.out.println(totalRectangulos+"\n");
        System.out.println(totalTriangulos);
        teclado.close();
    }
}
