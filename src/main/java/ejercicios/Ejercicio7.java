package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import recursos.trabajadores.Asalariado;
import recursos.trabajadores.ConsultorExterno;
import recursos.trabajadores.Trabajador;

/**
 * 9.7. Volviendo a la última parte del ejercicio 1.12, haz un programa que cree
 * un ArrayList que pueda contener tanto Asalariados como ConsultoresExternos e
 * introduzca “a mano” trabajadores de ambos tipos en el ArrayList. • Después
 * modificar el contenido del ArrayList añadiendo 1 hora extra/horas trabajada a
 * Asalariados y ConsultoresExternos respectivamente • Fijar el importe de hora
 * extra a 20 euros y la hora de consultor a 100 euros y modificar de nuevo el
 * ArrayList calculando el salario final de cada trabajador. • Finalmente,
 * recorriendo con un for-each el ArrayList, obtener el total que gastará la
 * empresa en salarios.
 */

public class Ejercicio7 {
    static LocalDate checkDate(String fecha) {
        try {
            return LocalDate.parse(fecha);
        } catch (Exception e) {
            System.out.println(e + "\nDefault date: 2000-02-09");
            return LocalDate.parse("2000-02-09");
        }
    }

    public static void main(String[] args) {
        final float HORACONSULTOR = 100f;
        final float IMPORTEHORASEXTRA = 20;
        ArrayList<Trabajador> asalariadoList = new ArrayList<Trabajador>();
        char option;
        String id;
        String nombre;
        LocalDate birthDate;
        float salarioTotal = 0f;
        Scanner teclado = new Scanner(System.in);
        do {
            option = teclado.nextLine().charAt(0);
            switch (option) {
                case 'c':
                    System.out.println("Introduce un id");
                    id = teclado.nextLine();
                    System.out.println("Introduce un nombre");
                    nombre = teclado.nextLine();
                    System.out.println("Introduce la fecha de nacimiento");
                    birthDate = checkDate(teclado.nextLine());
                    System.out.println("Introduce la base salarial");
                    float baseSalarial = Float.parseFloat(teclado.nextLine());
                    asalariadoList.add(new Asalariado(id, nombre, birthDate, baseSalarial));
                    break;
                case 't':
                    System.out.println("Introduce un id");
                    id = teclado.nextLine();
                    System.out.println("Introduce un nombre");
                    nombre = teclado.nextLine();
                    System.out.println("Introduce la fecha de nacimiento");
                    birthDate = checkDate(teclado.nextLine());
                    asalariadoList.add(new ConsultorExterno(id, nombre, birthDate));
                    break;
                default:
                    option = 'e';
                    break;
            }
        } while (option != 'e');
        //setting worked hours
        for (int i = 0; i < asalariadoList.size(); i++) {
            if (asalariadoList.get(i) instanceof Asalariado) {
                Asalariado asalariado = (Asalariado) asalariadoList.get(i);
                asalariado.setHorasExtra(1);
                asalariadoList.remove(i);
                asalariadoList.add(i, asalariado);
            } else if (asalariadoList.get(i) instanceof ConsultorExterno) {
                ConsultorExterno consultorExterno = (ConsultorExterno) asalariadoList.get(i);
                consultorExterno.setHorasTrabajadas(1);
                asalariadoList.remove(i);
                asalariadoList.add(i, consultorExterno);
            }
        }
        //calculating worked hours
        for (Trabajador trabajador : asalariadoList) {
            if (trabajador instanceof Asalariado) {
                Asalariado asalariado = (Asalariado) trabajador;
                asalariado.calcularSalarioFinal(IMPORTEHORASEXTRA);
                salarioTotal += asalariado.getSalarioFinal();
            } else if (trabajador instanceof ConsultorExterno) {
                ConsultorExterno consultorExterno = (ConsultorExterno) trabajador;
                consultorExterno.calcularSalarioFinal(HORACONSULTOR);
                salarioTotal += consultorExterno.getSalarioFinal();
            }
        }
        System.out.println("El salario total es de: "+salarioTotal);
        teclado.close();
    }
}
