package org.camilo.apiservlet.webapp.headers.services;


import jakarta.inject.Inject;
import org.camilo.apiservlet.webapp.headers.configs.Service;
import org.camilo.apiservlet.webapp.headers.models.Usuario;
import org.camilo.apiservlet.webapp.headers.repositories.UsuarioReporitory;


import java.sql.SQLException;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements  UsuarioService{

    private final UsuarioReporitory usuarioRepository;

    @Inject
    public UsuarioServiceImpl(UsuarioReporitory usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
