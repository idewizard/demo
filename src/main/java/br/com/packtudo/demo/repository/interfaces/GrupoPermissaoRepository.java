package br.com.packtudo.demo.repository.interfaces;

import br.com.packtudo.demo.model.entity.GrupoPermissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoPermissaoRepository extends JpaRepository<GrupoPermissao, Short>{

	
	// TODO: TRANSFORMAR EM CRYTIRA BUILDER JPA
	
	
	@Query( value = "SELECT MAX(COD_GRUPO_PERMISSAO) FROM GRUPO_PERMISSAO" , nativeQuery = true)
	short consultaMaxCodGrupoPermissao();

	@Query( value = "delete from GrupoPermissao where codGrupoPermissao = :id")
	boolean checaExistencia(Short id);
	
	
	
}
