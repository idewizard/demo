package br.com.packtudo.gaia.repository.interfaces;

import br.com.packtudo.gaia.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	//JPQL 
    @Query("delete from Usuario where desclogin = :descLogin")
    void deleteByDescLogin(String descLogin);
    
    Usuario findByDescLogin(String descLogin);
    
    Usuario findByBolAtivo(short bolAtivo);
}
