package ejercicios;

import recursos.figuras.Figura2D_v8;
import recursos.figuras.Triangulo_v8;

/**
 * 9.1. Realiza un programa con una variable de tipo Figura2D_v8, y sobre ella
 * llama a uno de los constructores de Triangulo_v8. Muestra sus dimensiones y
 * el cálculo del área.
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        Figura2D_v8 fV8 = new Triangulo_v8(8f,"Equilátero");
        System.out.println(fV8.getAlto());
        System.out.println(fV8.getAncho());
        System.out.println((fV8.getAlto()*fV8.getAncho())/2);
        System.out.println("Hello World");
    }
}
