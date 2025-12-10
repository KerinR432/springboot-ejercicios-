package BBDD.carritoDeLaCompra.repositories;
//* --------------------------- INTERFAZ --------------------------
import BBDD.carritoDeLaCompra.entities.ProductoAlmacen;
import org.springframework.data.repository.CrudRepository;
/**
 * Repositorio Spring Data JPA para la entidad {@link ProductoAlmacen}.
 * Un repositorio, era el punte entre el controlador y el objeto.
 * aqui usaremos un extención llamada crudRepository que hara su trabajo para poder interacturar
 * con la bases de datos.
 * */
public interface RepositorioProductoAlmacen extends CrudRepository<ProductoAlmacen,String> {
}
