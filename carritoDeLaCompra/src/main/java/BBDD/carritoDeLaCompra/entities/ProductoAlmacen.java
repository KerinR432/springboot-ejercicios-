package BBDD.carritoDeLaCompra.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductoAlmacen {
    @Id
    protected String nombre;
    protected double precio;
    protected int stock;

    public ProductoAlmacen() {
    }

    public ProductoAlmacen(int stock, double precio, String nombre) {
        this.stock = stock;
        this.precio = precio;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProductoAlmacen{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", precio=").append(precio);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }
}
