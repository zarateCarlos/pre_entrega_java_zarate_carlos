package src;

import java.util.Scanner;

import src.crud.CrudArticulos;
import src.crud.CrudCategorias;
import src.gestores.GestorProductos;



public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Instanciamos los CRUDs
        CrudArticulos crudArticulos = new CrudArticulos();
        CrudCategorias crudCategorias = new CrudCategorias();
        GestorProductos crudProductos = new GestorProductos(crudArticulos, crudCategorias);


        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1) CRUD Artículos");
            System.out.println("2) CRUD Categorías");
             System.out.println("3) CRUD Productos");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            String linea = scanner.nextLine();
            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> crudArticulos.iniciar();
                case 2 -> crudCategorias.iniciar();
                case 3 -> crudProductos.iniciar();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
