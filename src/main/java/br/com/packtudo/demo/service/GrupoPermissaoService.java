package br.com.packtudo.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.packtudo.demo.bean.ModelMapperBean;
import br.com.packtudo.demo.model.dto.GrupoPermissaoDTO;
import br.com.packtudo.demo.model.entity.GrupoPermissao;
import br.com.packtudo.demo.repository.interfaces.GrupoPermissaoRepository;
import org.springframework.stereotype.Service;

@Service
public class GrupoPermissaoService {

	@Autowired
	private GrupoPermissaoRepository grupoPermissaoRepository;
	
	@Autowired
	private ModelMapperBean modelMapperBean;
	
	@Transactional
	public GrupoPermissaoDTO save(GrupoPermissao grupoPermissao) {
		
		if(grupoPermissao.getDescGrupoPermissao() == null) {

			//TODO O QUE FAZER QUANDO NÃO TIVER A DESC
			//DEU MERDA, FAZ EXCECAO
			
		}
		
		if(grupoPermissao.getCodGrupoPermissao() == 0) {		
			
			grupoPermissao.setCodGrupoPermissao(
					grupoPermissaoRepository.consultaMaxCodGrupoPermissao());
			
		}
		
		GrupoPermissaoDTO grupoPermissaoDTO = new GrupoPermissaoDTO(); 
		modelMapperBean.modelMapper().map(grupoPermissao, grupoPermissaoDTO);
		
		
		return grupoPermissaoDTO;
	}

	public List<GrupoPermissao> findAll() {		
		return grupoPermissaoRepository.findAll();
	}

}
