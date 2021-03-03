package br.com.packtudo.gaia.controller;

import br.com.packtudo.gaia.model.dto.GrupoPermissaoDTO;
import br.com.packtudo.gaia.model.entity.GrupoPermissao;
import br.com.packtudo.gaia.model.exceptions.EntidadeNaoEncontradaException;
import br.com.packtudo.gaia.service.GrupoPermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GrupoPermissaoController extends AbstractController<GrupoPermissao, GrupoPermissaoDTO> {

	@Autowired
	private GrupoPermissaoService grupoPermissaoService;

	@GetMapping
	public ResponseEntity<List<GrupoPermissaoDTO>> findAll() {
		return responseSucesso(mapToListDTO(grupoPermissaoService.findAll()));
	}

	@PostMapping
	public ResponseEntity<GrupoPermissaoDTO> add(GrupoPermissaoDTO dto) {
		return responseSucesso(mapToDTO(grupoPermissaoService.save(mapToEntity(dto))));
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<GrupoPermissaoDTO> findById(Short codGrupoPermissao){
		try {
			return responseSucesso(mapToDTO(grupoPermissaoService.findById(codGrupoPermissao)));
		} catch (EntidadeNaoEncontradaException e) {
			getLogger().error("Entidade não localizada para o codGrupoPermissao %s".formatted(codGrupoPermissao), e);
			return responseNotFound();
		}
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping()
	public ResponseEntity<GrupoPermissaoDTO> deleteGrupoPermissao(GrupoPermissaoDTO dto ){
		
		var isRemoved = grupoPermissaoService.deleteGrupoPermissao(mapToEntity(dto));
		
		if( !isRemoved) {
			return responseNotFound();
		}
		
		return responseAnySucesso(dto);
	}
	
	//TODO: CRIAR O DELETE DO CRUD DESSA BAGAÇA  E CRIAR UMA PESQUISA ESPECIFICA
	
}
