package POO.heerencia.fruver.app;

import POO.heerencia.fruver.dominio.*;

public class Main {
    static void main() {

        //Crear el arreglo para almacenar los productos


        //Lacteos
        Producto lacteo1 = new Lacteo("Yogurt griego", 20.000, 10, 21);
        Producto lacteo2 = new Lacteo("Leche", 2000.0, 2, 1);

        //Frutas
        Producto fruta1 = new Fruta("Manzana", 2000.0, "Roja", 1.1);
        Producto fruta2 = new Fruta("Uvas", 155.000, "Morado", 4.6);

        //Productos de limpieza
        Producto limpieza1 = new Limpieza("Vinagre blanco", 12.000, "Agua, bicarbonato", 1.0);
        Producto limpieza2 = new Limpieza("Jabon", 5000.0, "Glicerina, agua", 2.0);

        //Productos no perecibles
        Producto noPerecible1 = new NoPerecible("Atun", 13000.0, 2, 1000);
        Producto noPerecible2 = new NoPerecible("Chocolates", 40.000, 20, 198800);


        Producto[] productos = {lacteo1, lacteo2, fruta1, fruta2, limpieza1, limpieza2, noPerecible1, noPerecible2};
        for (Producto producto : productos){
            if (producto != null){
                System.out.println(producto.toString());
            }
        }



    }
}
