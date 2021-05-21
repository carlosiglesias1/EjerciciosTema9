package ejercicios;

import java.util.Scanner;
import java.util.ArrayList;
import recursos.parking.*;

/**
 * 9.10. Haz un programa con un menú que permita gestionar un parking. • El
 * parking tiene 100 plazas y pueden aparcar 3 tipos de vehículos distintos:
 * Coches, Furgonetas y Autobuses. • Todos los vehículos pagan 4 céntimos por
 * minuto, pero las furgonetas pagan además un suplemento de 20 céntimos por
 * cada metro de su longitud y los autobuses pagan un suplemento de 25 céntimos
 * por asiento. • El menú del programa deberá permitir: a) Entrada de un
 * vehículo. Se le pide al usuario la matrícula, tipo de vehículo y datos
 * adicionales para el cálculo de la estancia (longitud, número de asientos…).
 * b) Salida del vehículo. Se le pide al usuario la matrícula, se calcula el
 * importe a pagar y libera la plaza. c) Mostrar la lista de vehículos en el
 * parking con la matrícula, tipo de vehículo y fecha/hora de llegada (piensa en
 * el método toString). Al final número total de plazas ocupadas. d) Salir •
 * Puedes hacer coste 4 céntimos por segundo (en vez de por minuto) para
 * probarlo. • No hay el concepto de número de plaza, los coches van aparcando
 * donde quieren. • Mantén la mayor cantidad de información (datos y cálculos)
 * en las clases, no en el programa. Puedes crear las clases en el mismo archivo
 * que el programa (por comodidad) con el modificador de acceso por defecto. •
 * El parking será un ArrayList. Para localizar un vehículo (en la opción de
 * menú de Salida del vehículo) emplea ArrayList.indexOf y ello te puede
 * implicar definir equals en alguna clase.
 */

public class Ejercicio10 {
    public static void main(String[] args) {
        ArrayList<Automobil> automobilList = new ArrayList<Automobil>();
        Scanner teclado = new Scanner(System.in);
        int length;
        String matricula;
        do {
            System.out.println(
                    "in: Entrada de un vehículo\nout: Salida de un vehículo\nshow: Ver los vehículos en el Parking\n'':Salir");
            length = teclado.nextLine().length();
            switch (length) {
                case 0:
                    break;
                case 2:
                    System.out.println("Escoje el tipo de Vehículo\n\tbus:Autobús\n\tfurgo:Furgoneta\n\tbuga:Coche");
                    length = teclado.nextLine().length();
                    System.out.println("Introduce la matrícula");
                    matricula = teclado.nextLine();
                    switch (length) {
                        case 3:
                            System.out.println("Introduce los asientos");
                            automobilList.add(new Autobus(matricula, Integer.parseInt(teclado.nextLine())));
                            break;
                        case 4:
                            automobilList.add(new Coche(matricula));
                        case 5:
                            System.out.println("Introduce los metros");
                            automobilList.add(new Furgoneta(matricula, Integer.parseInt(teclado.nextLine())));
                        default:
                            System.out.println("La has cagau pe bien cagá, tienes nuevo coche");
                            automobilList.add(new Coche(matricula));
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Introduce la matrícula del coche: ");
                    matricula = teclado.nextLine();
                    int position = automobilList.indexOf(new Automobil(matricula));
                    if(automobilList.get(position) instanceof Coche){
                        System.out.println("Hay que pagar "+automobilList.get(position).parkingPrice());
                    }else if (automobilList.get(position) instanceof Autobus){
                        Autobus autobus = (Autobus) automobilList.get(position);
                        System.out.println("El precio que hay que pagar es de: "+autobus.parkingPrice());
                    }else if (automobilList.get(position) instanceof Furgoneta){
                        Furgoneta furgoneta = (Furgoneta) automobilList.get(position);
                        System.out.println("Hay que pagar: "+furgoneta.parkingPrice());
                    }
                    automobilList.remove(position);
                    break;
                case 4: 
                    for (Automobil automobil : automobilList) {
                        System.out.println(automobil.toString());
                    }
                default:
                    break;
            }
        } while (length != 0);
        teclado.close();
    }
}
