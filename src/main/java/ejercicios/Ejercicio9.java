package ejercicios;

import recursos.pacientes.Paciente;
import java.util.ArrayList;
import java.util.Scanner;
import recursos.pacientes.PacienteConsulta;
import recursos.pacientes.PacienteRecetas;
import recursos.pacientes.PacienteRevision;

import java.time.LocalDate;

/**
 * 9.9. Haz un programa con un menú que permita gestionar la cola de espera de
 * un médico. Hay tres tipos de pacientes: los que vienen a consulta (se le pide
 * al usuario nombre, fecha de nacimiento, motivo de la consulta), los que viene
 * por recetas (se le pide: nombre, fecha de nacimiento, lista de medicamentos)
 * y el que viene a revisión (se le pide nombre, fecha de nacimiento y fecha de
 * la visita anterior). • Las tarifas del médico son: Consulta: 100 eur.
 * Recetas: 5 eur por cada unidad. Revisión: 30 eur para mayores de 65 años, 50
 * eur para resto. • Crear una clase para cada tipo de paciente en el propio
 * archivo del programa con los constructores necesarios y el método de
 * facturar() en cada una de las clases. Implementa herencia si lo crees
 * necesario. • El programa tendrá un menú para: a) Registrar la llegada del
 * paciente: se le preguntará por qué viene al médico y se le piden sus datos.
 * b) Llamar a consulta (por orden de llegada). Se le cobra la tarifa
 * correspondiente. c) Consultar total facturado hasta ese momento.
 */

public class Ejercicio9 {
    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
        char opcion;
        Scanner teclado = new Scanner(System.in);
        int paciente = 1;
        float totalFacturado = 0;
        do {
            System.out.println(
                    "Opciones:\n\ta: Añadir paciente\n\tp: Dar paso a un paciente\n\tc: Consultar facturado\n\te: Salir");
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
                case 'a':
                    System.out.println("Motivo de la consulta?\n\tr:Revisión\n\tc:Consulta\n\tp:Recetas");
                    opcion = teclado.nextLine().charAt(0);
                    switch (opcion) {
                        case 'r':
                            System.out.println("Nombre / Fecha de nacimiento (aaaa-mm-dd) / Fecha última revisión");
                            pacientes.add(new PacienteRevision(teclado.nextLine(), LocalDate.parse(teclado.nextLine()),
                                    LocalDate.parse(teclado.nextLine())));
                            break;
                        case 'c':
                            System.out.println("Nombre / Fecha de nacimiento (aaaa-mm-dd)/ Motivo de la Consulta");
                            pacientes.add(new PacienteConsulta(teclado.nextLine(), LocalDate.parse(teclado.nextLine()),
                                    teclado.nextLine()));
                            break;
                        case 'p':
                            System.out.println("Nombre / Fecha de nacimiento (aaaa-mm-dd)/ Lista de Recetas");
                            pacientes.add(new PacienteRecetas(teclado.nextLine(), LocalDate.parse(teclado.nextLine()),
                                    new ArrayList<String>()));
                            break;
                        default:
                            System.out.println("Oh vaya, semejante cagada!");
                            break;
                    }
                    break;
                case 'p':
                    System.out.println("Que pase el paciente " + paciente + "!");
                    paciente++;
                    Paciente paciente2 = pacientes.get(0);
                    if (paciente2 instanceof PacienteConsulta) {
                        totalFacturado += PacienteConsulta.PRECIOCONSULTA;
                    } else if (paciente2 instanceof PacienteRecetas) {
                        totalFacturado += PacienteRecetas.PRECIOCONSULTA;
                    } else if (paciente2 instanceof PacienteRevision) {
                        PacienteRevision pacienteRevision = (PacienteRevision) paciente2;
                        if (pacienteRevision.precioReducido())
                            totalFacturado += pacienteRevision.PRECIOMAYORES65;
                        else
                            totalFacturado += pacienteRevision.PRECIOMENORES;
                    }
                    break;
                case 'c':
                    System.out.println("Total facturado hasta ahora: " + totalFacturado);
                    break;
                case 'e':
                    break;
                default:
                    System.out.println(
                            "Baya cagadita eh, no te fijes en las faltas de ortografía y escoje una opción korrecta");
                    break;
            }
        } while (opcion != 'e');
        teclado.close();
    }
}
