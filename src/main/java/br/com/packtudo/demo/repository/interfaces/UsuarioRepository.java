package br.com.packtudo.demo.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.packtudo.demo.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    @Query("delete from Usuario where desclogin = :descLogin")
    void deleteByDescLogin(String descLogin);
}
