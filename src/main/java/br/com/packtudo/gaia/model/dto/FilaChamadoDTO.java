package br.com.packtudo.gaia.model.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class FilaChamadoDTO {

	private Integer codFilaChamado;
	private Timestamp dataHoraInclusao;
	private String descFilaChamado;
	private List<GrupoPermissaoDTO> grupoPermissaos;
	private List<ChamadoDTO> chamados;

}