package br.com.packtudo.gaia.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class StatusChamadoDTO {

	private short codStatusChamado;
	private String descStatusChamado;
	private List<ChamadoDTO> chamados;

}