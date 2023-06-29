package org.camilo.apiservlet.webapp.headers.repositories;

import org.camilo.apiservlet.webapp.headers.models.Usuario;

import java.sql.SQLException;

public interface UsuarioReporitory extends CrudRepository<Usuario> {

    Usuario porUsername (String username) throws SQLException;
}
