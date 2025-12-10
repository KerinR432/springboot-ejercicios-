package BBDD.carritoDeLaCompra.repositories;

import BBDD.carritoDeLaCompra.entities.ProductoAlmacen;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioProductoAlmacen extends CrudRepository<ProductoAlmacen,String> {
}
