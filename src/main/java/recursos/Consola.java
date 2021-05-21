package recursos;

import java.util.Scanner;

/**
 * Crea una clase llamada Consola con un método estático sobrecargado llamado
 * leerEntero() que solicite al usuario que teclee un valor entero, cumpliendo
 * las siguientes características: • Si no se le pasa ningún parámetro, no tiene
 * requisitos, es simplemente un nextInt(). • Si se le pasa un parámetro de tipo
 * texto, escribe ese texto antes de solicitar el valor. Ejemplo: leerEntero
 * (“Introduzca su edad”); • Si se le pasa un parámetro tipo texto y dos
 * enteros, garantizará que el valor tecleado esté comprendido entre ambos.
 * Ejemplo: leerEntero (“Introduzca su edad”, 0, 120); • Si se le pasan dos
 * enteros, garantizará que el valor tecleado esté comprendido entre ambos, pero
 * no muestra texto de instrucciones previo. Ejemplo: System.out.println
 * (“Introduzca su edad”); leerEntero (0, 120);
 */

public class Consola {
    private Scanner teclado;

    public Consola() {
        this.teclado = new Scanner(System.in);
    }

    public int leerEntero() {
        return this.teclado.nextInt();
    }

    public int leerEntero(String caracteres) {
        System.out.println(caracteres);
        return this.teclado.nextInt();
    }

    public int leerEntero (int cotaInferior, int cotaSuperior) throws Exception{
        int i = this.teclado.nextInt();
        if (i > cotaSuperior || i < cotaInferior)
            throw new RuntimeException("Invalid int: it may be between begin and end");
        else
            return i;
    }

    public int leerEntero(String caracteres, int cotaInferior, int cotaSuperior) throws Exception {
        System.out.println(caracteres);
        int i = this.teclado.nextInt();
        if (i > cotaSuperior || i < cotaInferior)
            throw new RuntimeException("Invalid int: it may be between begin and end");
        else
            return i;
    }
}
