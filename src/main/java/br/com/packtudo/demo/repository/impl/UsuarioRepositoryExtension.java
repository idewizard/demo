package br.com.packtudo.demo.repository.impl;

import br.com.packtudo.demo.model.entity.Usuario;
import br.com.packtudo.demo.repository.interfaces.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class UsuarioRepositoryExtension {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntityManager em;

    public Usuario save(Usuario entity) {
        return usuarioRepository.save(entity);
    }

    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public boolean checarExistencia(Integer id) {

        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        final Root<Usuario> from = cq.from(Usuario.class);

        cq.select(cb.count(from));
        cq.where(cb.equal(from.get("idUsuario"), id));

        final TypedQuery<Long> tq = em.createQuery(cq);
        return tq.getSingleResult() > 0;
    }
}
