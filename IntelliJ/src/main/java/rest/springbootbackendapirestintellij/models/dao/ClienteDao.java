package rest.springbootbackendapirestintellij.models.dao;

import org.springframework.data.repository.CrudRepository;
import rest.springbootbackendapirestintellij.models.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
}
