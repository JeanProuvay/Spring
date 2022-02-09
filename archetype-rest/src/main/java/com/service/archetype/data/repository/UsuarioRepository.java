package com.service.archetype.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.service.archetype.data.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    public Usuario findByUsernameAndEmail(String username, String email);

    public Usuario findByUsername(String username);

    @Query("select u from Usuario u where u.username=?1")
    public Usuario findByUsernameQuery(String username);
}