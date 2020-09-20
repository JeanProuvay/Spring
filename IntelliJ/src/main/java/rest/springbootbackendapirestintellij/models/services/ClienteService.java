package rest.springbootbackendapirestintellij.models.services;

import rest.springbootbackendapirestintellij.models.entity.Cliente;
import java.util.List;

public interface ClienteService {
    public List<Cliente> findAll();
}
