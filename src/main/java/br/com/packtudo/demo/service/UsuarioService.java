package br.com.packtudo.demo.service;

import br.com.packtudo.demo.model.entity.Usuario;
import br.com.packtudo.demo.repository.impl.UsuarioRepositoryExtension;
import br.com.packtudo.demo.repository.interfaces.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService extends AbstractService<Usuario> {

    @Autowired
    private UsuarioRepositoryExtension usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario add(Usuario entity) {
        return usuarioRepository.save(entity);
    }

    public boolean delete(Integer id) {
        if(!usuarioRepository.checarExistencia(id)){
            return false;
        }
        usuarioRepository.deleteById(id);
        return true;
    }
}
