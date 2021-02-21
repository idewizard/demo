package br.com.packtudo.demo.service;

import br.com.packtudo.demo.model.entity.Usuario;
import br.com.packtudo.demo.repository.impl.UsuarioRepositoryExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioService extends AbstractService<Usuario> {

    @Autowired
    private UsuarioRepositoryExtension usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario add(Usuario entity) {
        entity.setDataHoraInclusao(new Timestamp(new Date().getTime()));
        return usuarioRepository.save(entity);
    }

    public boolean deleteByDescLogin(String descLogin) {
        if(!usuarioRepository.checarExistencia(descLogin)){
            return false;
        }
        usuarioRepository.deleteByDescLogin(descLogin);
        return true;
    }
}
