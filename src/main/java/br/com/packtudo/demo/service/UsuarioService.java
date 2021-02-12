package br.com.packtudo.demo.service;

import br.com.packtudo.demo.model.entity.Usuario;
import br.com.packtudo.demo.model.exceptions.PropertyNullException;
import br.com.packtudo.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService extends AbstractService<Usuario> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario add(Usuario entity) throws PropertyNullException {
        return usuarioRepository.save(entity);
    }
}
