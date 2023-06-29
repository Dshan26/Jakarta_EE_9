package org.camilo.apiservlet.webapp.headers.services;

import org.camilo.apiservlet.webapp.headers.models.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}
