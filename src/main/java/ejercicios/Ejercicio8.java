package ejercicios;

import recursos.Consola;

/**
 * 9.8. Crea una clase llamada Consola con un método estático sobrecargado
 * llamado leerEntero() que solicite al usuario que teclee un valor entero,
 * cumpliendo las siguientes características: • Si no se le pasa ningún
 * parámetro, no tiene requisitos, es simplemente un nextInt(). • Si se le pasa
 * un parámetro de tipo texto, escribe ese texto antes de solicitar el valor.
 * Ejemplo: leerEntero (“Introduzca su edad”); • Si se le pasa un parámetro tipo
 * texto y dos enteros, garantizará que el valor tecleado esté comprendido entre
 * ambos. Ejemplo: leerEntero (“Introduzca su edad”, 0, 120); • Si se le pasan
 * dos enteros, garantizará que el valor tecleado esté comprendido entre ambos,
 * pero no muestra texto de instrucciones previo. Ejemplo: System.out.println
 * (“Introduzca su edad”); leerEntero (0, 120); Finalmente, haz un programa que
 * pruebe todas las variantes del método.
 */

public class Ejercicio8 {
    public static void main(String[] args) {
        Consola consola = new Consola();

        consola.leerEntero();
        consola.leerEntero("A veces me hago mucha caca");
        try {
            consola.leerEntero(0, 120);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            consola.leerEntero("Me huele el pito a canela", 0, 120);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
