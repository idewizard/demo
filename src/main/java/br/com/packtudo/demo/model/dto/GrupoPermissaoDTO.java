package br.com.packtudo.demo.model.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class GrupoPermissaoDTO {

	private short codGrupoPermissao;
	private Timestamp dataHoraInclusao;
	private String descGrupoPermissao;
	private List<UsuarioDTO> usuarios;
	private List<FilaChamadoDTO> filaChamados;
}