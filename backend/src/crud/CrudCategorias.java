package src.crud;

import java.util.ArrayList;
import java.util.Scanner;

import src.interfaces.CrudBasico;
import src.modelos.Categoria;

public class CrudCategorias implements CrudBasico<Categoria> {

    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Categoria> listaCategorias = new ArrayList<>();

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    @Override
    public void crear() {
        int id = leerEntero("Id de la nueva categoría: ");
        System.out.print("Nombre de la nueva categoría: ");
        String nombre = scanner.nextLine();
        listaCategorias.add(new Categoria(id, nombre));
        System.out.println("Categoría creada.");
    }

    @Override
    public void listar() {
        if (listaCategorias.isEmpty()) {
            System.out.println("(sin categorías)");
        } else {
            for (Categoria c : listaCategorias) {
                System.out.println(c);
            }
        }
    }

    @Override
    public void actualizar() {
        int id = leerEntero("Id de la categoría a actualizar: ");
        for (Categoria c : listaCategorias) {
            if (c.getId() == id) {
                System.out.print("Nuevo nombre: ");
                String nuevo = scanner.nextLine();
                c.setNombre(nuevo);
                System.out.println("Categoría actualizada: " + c);
                return;
            }
        }
        System.out.println("No se encontró categoría con id " + id);
    }

    @Override
    public void eliminar() {
        int id = leerEntero("Id de la categoría a eliminar: ");
        boolean eliminado = listaCategorias.removeIf(c -> c.getId() == id);
        System.out.println(eliminado ? "Categoría eliminada." : "No existía ese id.");
    }

    // --- Extras internos ---
    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return leerEntero();
    }

    private int leerEntero() {
        while (true) {
            try {
                String linea = scanner.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.print("Debe ser un número. Intente de nuevo: ");
            }
        }
    }

    // Menú
    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n=== CRUD Categorías ===");
            System.out.println("1) Crear categoría");
            System.out.println("2) Listar categorías");
            System.out.println("3) Actualizar categoría");
            System.out.println("4) Eliminar categoría");
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
}
