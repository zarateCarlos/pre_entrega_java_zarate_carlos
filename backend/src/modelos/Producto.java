package src.modelos;

public class Producto {
    private Articulo articulo;
    private Categoria categoria;

    public Producto(Articulo articulo, Categoria categoria) {
        this.articulo = articulo;
        this.categoria = categoria;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Producto: " + articulo.getDescripcion() + 
               " | Categoría: " + categoria.getNombre();
    }
}
