package rest.springbootbackendapirestintellij.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.springbootbackendapirestintellij.models.dao.ClienteDao;
import rest.springbootbackendapirestintellij.models.entity.Cliente;
import java.util.List;

@Service
public class ClienteServiceImplement implements ClienteService{

    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }
}