package BBDD.carritoDeLaCompra.services;

import BBDD.carritoDeLaCompra.entities.ProductoAlmacen;
import BBDD.carritoDeLaCompra.repositories.RepositorioProductoAlmacen;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * Servicos, este apartado ha sido algo nuevo que he apredido.
 * es el que se come la carga pesada y luego la aroja, todo lo que no queramos tener el en controlador va
 * aqui, es el cerebro, mientras que el controlador solo le pasa lo que ve y espera la logica de vuelta
 * para mostrar.
 * de momento tenemos un clases ServicioAlmacen, donde primero ejecutaremos o buscaremos el objeto almacen
 * y llamaremos a la interfaz que nos crea todo esto, a su ves creamos todas la tablas 1 vez.
 * Luego tenemos un función que pasa una lista de productos del alamcen, devuelve todo el almacen.
 * Y otra función donde cada ve que se pide un producto, se va restando del producto que exite en
 * la bases de datos.
 * */
@Service
public class ServicioAlmacen {
    // Llamos al repositorio que hara posible la conectividad
    private RepositorioProductoAlmacen repositorioProductoAlmacen;
    // esta función a parte que busca ese repositorio, crea las tablas una vez
    // @param gracias a su condición, si el repositorioAlamacen ya tiene tablas, no debe crearlas otra vez.
    public ServicioAlmacen(RepositorioProductoAlmacen repositorioProductoAlmacen) {
        this.repositorioProductoAlmacen = repositorioProductoAlmacen;
        //condición para saber si el repositorioAlmacen tiene tablas creadas.
        if(repositorioProductoAlmacen.count() ==0) {
            repositorioProductoAlmacen.save(new ProductoAlmacen(100,3.5,"Plátanos"));
            repositorioProductoAlmacen.save(new ProductoAlmacen(100,5.4,"Pepinos"));
            repositorioProductoAlmacen.save(new ProductoAlmacen(100,2.5,"Manzanas"));
        }
    }

    // Aqui devolvemos todo los datos que encontramos en una lista que su vez, almacena todo los productos
    // @return una lista de objetos ProductoAlmacen.
    public List<ProductoAlmacen> getAll(){
        return (List<ProductoAlmacen>) repositorioProductoAlmacen.findAll();

    }
    // Aqui es donde haremos una magia y es borrar la cantidad 'x' hemos ecogido de un producto enconcreto
    // y la restaremos y lo volveremos almacenar, como si estuvieras sobre escribiendo o restandole al stock
    // que existe en el producto
    public void restaStock(Map<String,String> productos) {
        //recorremos todo el mapa de productos, obteniendo la clave primaria e ella.
        for (String producto : productos.keySet()) {
            // a producto almacen le pasamos lo que econtramos como clave primaria, sino le pasamos un null
            ProductoAlmacen productoAlmacen = repositorioProductoAlmacen.findById(producto).orElse(null);
            // hacemos una condición si no es nulo, haremos que el stock sea alterado, guardando
            // el stock del almacen (el que esta en la bases de datos) y restandolo por la cantidad de produtos
            //que hemos sacado de la pagina.
            if (productoAlmacen != null) {
            productoAlmacen.setStock(productoAlmacen.getStock() - Integer.parseInt(productos.get(producto)));
            repositorioProductoAlmacen.save(productoAlmacen);
            }
            // Devolvemos un error si es nulo.
            else{
                System.err.println("No existe el producto con el id: " + producto);
            }
        }
    }
}
