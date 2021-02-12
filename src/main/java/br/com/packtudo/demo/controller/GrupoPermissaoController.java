package br.com.packtudo.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.packtudo.demo.model.dto.GrupoPermissaoDTO;
import br.com.packtudo.demo.model.entity.GrupoPermissao;
import br.com.packtudo.demo.service.GrupoPermissaoService;

@RestController
public class GrupoPermissaoController {
	
	@Autowired
	private GrupoPermissaoService grupoPermissaoService;
	
	@GetMapping
	public List<GrupoPermissao> findAll(){
		return grupoPermissaoService.findAll();
	}
	
	@PostMapping
	public GrupoPermissaoDTO add(GrupoPermissao grupoPermissao) {
		return grupoPermissaoService.save(grupoPermissao);
	}
	
	

}
