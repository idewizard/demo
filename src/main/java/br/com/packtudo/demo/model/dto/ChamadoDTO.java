package br.com.packtudo.demo.model.dto;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class ChamadoDTO {

	private Integer idChamado;
	private Timestamp dataHoraEncerramento;
	private Timestamp dataHoraInclusao;
	private String descChamado;
	private String descTituloChamado;
	private FilaChamadoDTO filaChamado;
	private UsuarioDTO usuarioResponsavel;
	private UsuarioDTO usuarioSolicitante;
	private StatusChamadoDTO statusChamado;
}