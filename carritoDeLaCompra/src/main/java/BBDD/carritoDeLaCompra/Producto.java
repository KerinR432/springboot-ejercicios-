package BBDD.carritoDeLaCompra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nProducto;
    private Double precio;
    private  Integer stock;

    public Producto() {
    }

    public Producto( String nProducto, Double precio,Integer stock) {
        this.nProducto = nProducto;
        this.precio = precio;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getnProducto() {
        return nProducto;
    }

    public void setnProducto(String nProducto) {
        this.nProducto = nProducto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Producto{");
        sb.append("id=").append(id);
        sb.append(", nProducto='").append(nProducto).append('\'');
        sb.append(", precio=").append(precio);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }
}
