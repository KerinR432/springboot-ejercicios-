package BBDD.carritoDeLaCompra.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//* -------------------------- OBJETO -------------------------
/**
 * Creamos lo que es una entidad que sera nuestra base de datos o sera ese puente hacia ella
 * creamos 2 constructures, uno que le pasamos algo por parametro o otro que es vacio y nos ayudara
 * con la interfaz.
 * Tambíen aqui declararemos lo que sera la varible que sera el Id o esa clave de indetificación
 * tenemos varias variables privadas
 * @param nombre que es el 'id' ejemplo('patatas').
 * @param precio ejemplo(12€).
 * @param stock ejemplo(100) unidades.
 * en generar creamos getters y setters de todo, asi como un toString para poder depurar si queremos.
 * */
@Entity
public class ProductoAlmacen {
    //varible importante, es la cual usaremos para poder refererir a los demas datos
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
