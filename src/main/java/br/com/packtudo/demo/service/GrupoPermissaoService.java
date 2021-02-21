package br.com.packtudo.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.packtudo.demo.model.entity.GrupoPermissao;
import br.com.packtudo.demo.repository.interfaces.GrupoPermissaoRepository;
import org.springframework.stereotype.Service;

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

	public GrupoPermissao findById(GrupoPermissao grupoPermissao) {
		return grupoPermissaoRepository.findById(grupoPermissao.getCodGrupoPermissao()).orElse(grupoPermissao);
	}
	
	
	public boolean deleteGrupoPermissao(GrupoPermissao grupoPermissao) {
		if (!grupoPermissaoRepository.checaExistencia(grupoPermissao.getCodGrupoPermissao())) {
			return false;
		}
		grupoPermissaoRepository.deleteById(grupoPermissao.getCodGrupoPermissao());;
		return true;
	}
	
}
