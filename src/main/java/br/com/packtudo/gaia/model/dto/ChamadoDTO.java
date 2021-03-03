package br.com.packtudo.gaia.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
public class ChamadoDTO {

	private Integer idChamado;
	private Timestamp dataHoraEncerramento;
	private Timestamp dataHoraInclusao;
	private String descChamado;
	private String descTituloChamado;
	private FilaChamadoDTO filaChamado;

	//@NotBlank(message = "Campo de preenchimento obrigatório - Usuário Responsável")
	private UsuarioDTO usuarioResponsavel;

	//@NotBlank(message = "Campo de preenchimento obrigatório - Usuário Solicitante")
	private UsuarioDTO usuarioSolicitante;
	private StatusChamadoDTO statusChamado;
}