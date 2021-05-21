package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

import recursos.Bicicleta;

/**
 * 9.12. Crea una clase Bicicleta de la que deseamos mantener los siguientes
 * datos: marca, modelo, precio y descuento. Se pide crear el constructor,
 * getters y setters, método toString (), equals (), un método que devuelva el
 * precio con el descuento aplicado y finalmente un método que fije el descuento
 * a aplicar. Este último método estará sobrecargado de la siguiente forma: •
 * fjarDescuento ()  (se le hace 10% y dura ese descuento 1 mes) •
 * fjarDescuento (double d)  (se le hace d %, 1 mes) • fjarDescuento (double d
 * , int n)  (se le hace d %, n meses) Haz un programa sencillo que defina una
 * o dos instancias de bicicletas y use los métodos creados Notas: • Dos
 * bicicletas son iguales si tienen la misma marca y modelo. • Si se fija un
 * descuento, se elimina el descuento que pudiera haber anteriormente. • Piensa
 * si es necesario incorporar algún atributo adicional, para que, cuando
 * ejecutemos el método de ver el precio final (con descuento aplicado), sepa si
 * tiene que aplicar algún descuento o no.
 */

public class Ejercicio12 {
    public static void main(String[] args) {
        ArrayList <Bicicleta> bicicletas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            bicicletas.add(new Bicicleta(teclado.nextLine(), teclado.nextLine(), Float.parseFloat(teclado.nextLine())));
        }
        for (int i = 0; i < bicicletas.size(); i++) {
            for (int j = 0; j < bicicletas.size(); j++) {
                if(bicicletas.get(i).equals(bicicletas.get(j))&&i!=j)
                    System.out.println("Hay bicicletas iguales");
            }
        }

        for (Bicicleta bicicleta : bicicletas) {
            System.out.println(bicicleta.toString());
        }
        teclado.close();
    }
}
