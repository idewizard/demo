package br.com.packtudo.gaia.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.List;

@Data
public class GrupoPermissaoDTO {

	@NotBlank ( message = "Campo Codigo é de preenchimento obrigatório")
	private short codGrupoPermissao;
	private Timestamp dataHoraInclusao;
	
	@NotBlank ( message = "Campo Descrição é de preenchimento obrigatório")
	private String descGrupoPermissao;
	private List<UsuarioDTO> usuarios;
	private List<FilaChamadoDTO> filaChamados;
	
}