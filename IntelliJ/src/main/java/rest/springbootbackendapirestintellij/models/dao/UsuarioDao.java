
package rest.springbootbackendapirestintellij.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rest.springbootbackendapirestintellij.models.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

    public Usuario findByUsernameAndEmail(String username, String email);

    public Usuario findByUsername(String username);

    @Query("select u from Usuario u where u.username=?1")
    public Usuario findByUsernameQuery(String username);
}
