package Persistencia.BBDJPA;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioCliente extends CrudRepository<Cliente,Long> {

    List<Cliente> findByApellido(String apellido);

    Cliente findById(long id);

}
