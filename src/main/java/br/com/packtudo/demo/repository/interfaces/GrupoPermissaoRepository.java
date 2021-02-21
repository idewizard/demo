package br.com.packtudo.demo.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.packtudo.demo.model.entity.GrupoPermissao;

@Repository
public interface GrupoPermissaoRepository extends JpaRepository<GrupoPermissao, Short>{

	
	// TODO: TRANSFORMAR EM CRYTIRA BUILDER JPA
	
	
	@Query( value = "SELECT MAX(COD_GRUPO_PERMISSAO) FROM GRUPO_PERMISSAO" , nativeQuery = true)
	short consultaMaxCodGrupoPermissao();

	@Query( value = "delete from grupo_permissao where cod_grupo_permissao = :id")
	boolean checaExistencia(short id);
	
	
	
}
