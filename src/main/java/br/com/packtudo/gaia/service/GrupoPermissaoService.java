package br.com.packtudo.gaia.service;

import br.com.packtudo.gaia.model.entity.GrupoPermissao;
import br.com.packtudo.gaia.model.exceptions.EntidadeNaoEncontradaException;
import br.com.packtudo.gaia.repository.interfaces.GrupoPermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Service
public class GrupoPermissaoService {

	@Autowired
	private GrupoPermissaoRepository grupoPermissaoRepository;
	
	@Transactional
	public GrupoPermissao save(@Valid GrupoPermissao grupoPermissao) {
	
		if(grupoPermissao.getCodGrupoPermissao() == 0) {		
			
			grupoPermissao.setCodGrupoPermissao(
					grupoPermissaoRepository.consultaMaxCodGrupoPermissao());
			
		}
		
		return grupoPermissaoRepository.save(grupoPermissao);
		
	}

	public List<GrupoPermissao> findAll() {		
		return grupoPermissaoRepository.findAll();
	}

	public GrupoPermissao findById(Short codGrupoPermissao) throws EntidadeNaoEncontradaException {
		return grupoPermissaoRepository.findById(codGrupoPermissao).orElseThrow(EntidadeNaoEncontradaException::new);
	}

	public boolean deleteGrupoPermissao(GrupoPermissao grupoPermissao) {
		if (!grupoPermissaoRepository.checaExistencia(grupoPermissao.getCodGrupoPermissao())) {
			return false;
		}
		grupoPermissaoRepository.deleteById(grupoPermissao.getCodGrupoPermissao());
		return true;
	}
	
}
