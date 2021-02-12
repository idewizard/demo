package br.com.packtudo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.packtudo.demo.model.entity.GrupoPermissao;

@Repository
public interface GrupoPermissaoRepository extends JpaRepository<GrupoPermissao, Long>{

	@Query( value = "SELECT MAX(COD_GRUPO_PERMISSAO) FROM GRUPO_PERMISSAO" , nativeQuery = true)
	short consultaMaxCodGrupoPermissao();
	
}
