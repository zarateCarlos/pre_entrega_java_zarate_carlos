package src.gestores;

import java.util.ArrayList;
import java.util.Scanner;

import src.crud.CrudArticulos;
import src.crud.CrudCategorias;
import src.modelos.Producto;

public class GestorProductos {

    private final ArrayList<Producto> listaProductos = new ArrayList<>();
    private final CrudArticulos crudArticulos;
    private final CrudCategorias crudCategorias;
    private final Scanner scanner = new Scanner(System.in);

    // Constructor recibe los CRUD existentes (para acceder a sus listas)
    public GestorProductos(CrudArticulos crudArticulos, CrudCategorias crudCategorias) {
        this.crudArticulos = crudArticulos;
        this.crudCategorias = crudCategorias;
    }

    // Menú principal
    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n=== CRUD de Productos ===");
            System.out.println("1. Asignar Categoría a Artículo");
            System.out.println("2. Listar Productos con Categoría");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> asignarCategoria();
                case 2 -> listarProductos();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    // Asignar categoría a un artículo existente
    private void asignarCategoria() {
      

        System.out.println("\n-- Artículos disponibles --");
        var articulos = crudArticulos.getListaArticulos();
        for (int i = 0; i < articulos.size(); i++) {
            System.out.println((i + 1) + ". " + articulos.get(i));
        }

        System.out.print("Elija el número del artículo: ");
        int indexArticulo = scanner.nextInt() - 1;
        if (indexArticulo < 0 || indexArticulo >= articulos.size()) {
            System.out.println("Número inválido.");
            return;
        }

        System.out.println("\n-- Categorías disponibles --");
        var categorias = crudCategorias.getListaCategorias();
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " + categorias.get(i));
        }

        System.out.print("Elija la categoría: ");
        int indexCategoria = scanner.nextInt() - 1;
        if (indexCategoria < 0 || indexCategoria >= categorias.size()) {
            System.out.println("Número inválido.");
            return;
        }

        Producto nuevo = new Producto(articulos.get(indexArticulo), categorias.get(indexCategoria));
        listaProductos.add(nuevo);
        System.out.println("✅ Categoría asignada correctamente.");
    }

    // Listar relaciones producto-categoría
    private void listarProductos() {
        System.out.println("\n-- Productos con Categoría --");
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos asignados.");
            return;
        }
        for (Producto p : listaProductos) {
            System.out.println(p);
        }
    }
}
