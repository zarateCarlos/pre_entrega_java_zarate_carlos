package src.crud;

import java.util.ArrayList;
import java.util.Scanner;

import src.interfaces.CrudBasico;
import src.modelos.Articulo;

public class CrudArticulos implements CrudBasico<Articulo> {

    private final ArrayList<Articulo> listaArticulos = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public ArrayList<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n=== CRUD Artículos ===");
            System.out.println("1) Crear artículo");
            System.out.println("2) Listar artículos");
            System.out.println("3) Modificar artículo");
            System.out.println("4) Eliminar artículo");
            System.out.println("0) Volver al menú principal");
            System.out.print("Opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> crear();
                case 2 -> listar();
                case 3 -> actualizar();
                case 4 -> eliminar();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    // Metodos de la interfaz CRUD
   

    @Override
    public void crear() {
        System.out.println("=== Crear Artículo ===");

        System.out.print("ID: ");
        int id = leerEntero();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = leerDouble();

        Articulo nuevo = new Articulo(id, nombre, descripcion, precio);
        listaArticulos.add(nuevo);

        System.out.println("Artículo agregado correctamente.\n");
    }

    @Override
    public void listar() {
        System.out.println("=== Lista de Artículos ===");

        if (listaArticulos.isEmpty()) {
            System.out.println("No hay artículos cargados.\n");
            return;
        }

        for (Articulo art : listaArticulos) {
            System.out.println(art);
        }
        System.out.println();
    }

    @Override
    public void actualizar() {
        System.out.println("=== Modificar Artículo ===");
        System.out.print("Ingrese ID del artículo: ");
        int id = leerEntero();

        Articulo encontrado = buscarPorId(id);

        if (encontrado == null) {
            System.out.println("Artículo no encontrado.\n");
            return;
        }

        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Nueva descripción: ");
        String nuevaDescripcion = scanner.nextLine();

        System.out.print("Nuevo precio: ");
        double nuevoPrecio = leerDouble();

        encontrado.setNombre(nuevoNombre);
        encontrado.setDescripcion(nuevaDescripcion);
        encontrado.setPrecio(nuevoPrecio);

        System.out.println("Artículo modificado correctamente.\n");
    }

    @Override
    public void eliminar() {
        System.out.println("=== Eliminar Artículo ===");
        System.out.print("Ingrese ID del artículo: ");
        int id = leerEntero();

        Articulo encontrado = buscarPorId(id);

        if (encontrado == null) {
            System.out.println("Artículo no encontrado.\n");
            return;
        }

        listaArticulos.remove(encontrado);
        System.out.println("Artículo eliminado correctamente.\n");
    }

   
    // Metodos auxiliares
   

    private Articulo buscarPorId(int id) {
        for (Articulo art : listaArticulos) {
            if (art.getId() == id) return art;
        }
        return null;
    }

    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Debe ser un número entero. Intente de nuevo: ");
            }
        }
    }

    private double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Debe ser un número (use punto). Intente de nuevo: ");
            }
        }
    }
}
