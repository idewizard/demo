package br.com.packtudo.demo.model.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the chamado database table.
 * 
 */
@Entity
@NamedQuery(name="Chamado.findAll", query="SELECT c FROM Chamado c")

@Data
public class Chamado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_chamado")
	private Integer idChamado;

	@Column(name="data_hora_encerramento")
	private Timestamp dataHoraEncerramento;

	@Column(name="data_hora_inclusao")
	private Timestamp dataHoraInclusao;

	@Column(name="desc_chamado")
	private String descChamado;

	@Column(name="desc_titulo_chamado")
	private String descTituloChamado;

	//bi-directional many-to-one association to FilaChamado
	@ManyToOne
	@JoinColumn(name="cod_fila_chamado")
	private FilaChamado filaChamado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_responsavel")
	private Usuario usuarioResponsavel;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_solicitante")
	private Usuario usuarioSolicitante;

	//bi-directional many-to-one association to StatusChamado
	@ManyToOne
	@JoinColumn(name="cod_status_chamado")
	private StatusChamado statusChamado;
}