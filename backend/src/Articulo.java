package src;

public class Articulo {
    // Encapsulamiento
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;

    // Constructor vacío (necesario para crear objetos sin datos iniciales)
    public Articulo() {}

    // Constructor con parámetros (para crear directamente con valores)
    public Articulo(int id, String nombre, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

       public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Descripción: " + descripcion + " | Precio: $" + precio;
    }
}
