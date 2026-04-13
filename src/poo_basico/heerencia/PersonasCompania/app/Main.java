package POO.heerencia.PersonasCompania.app;

import POO.heerencia.PersonasCompania.dominio.Cliente;
import POO.heerencia.PersonasCompania.dominio.Empleado;
import POO.heerencia.PersonasCompania.dominio.Gerente;

public class Main {
    static void main() {

        //Cliente
        System.out.println("CLIENTE");
        Cliente cliente = new Cliente("Caterine", "Sanchez", "Prueba", "Bogota");
        Cliente cliente2 = new Cliente("Cater", "Sanz", "Prueba2", "Socaha");
        System.out.println(cliente.toString());
        System.out.println(cliente2.toString());

        //Empleado
        System.out.println("Empleado");
        Empleado empleado = new Empleado("Carlos", "Salinas", "WERWR", "Puero asis", 100.000);
        try {
            empleado.aumentarRemuneracion(1);
            System.out.println(empleado.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //Gerente
        System.out.println("Gerente");
        Gerente gerente = new Gerente("Lorena", "Bolaños", "EWRET", "Huila", 300.000, 1000.000);
        gerente.aumentarRemuneracion(2);
        System.out.println(gerente.toString());


    }
}
