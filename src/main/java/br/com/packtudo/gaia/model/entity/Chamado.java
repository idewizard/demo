package br.com.packtudo.gaia.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the chamado database table.
 * 
 */
@Entity
@NamedQuery(name="Chamado.findAll", query="SELECT c FROM Chamado c")
public class Chamado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_chamado")
	private Integer idChamado;

	@Getter
	@Setter
	@Column(name="data_hora_encerramento")
	private Timestamp dataHoraEncerramento;

	@Getter
	@Setter
	@Column(name="data_hora_inclusao")
	private Timestamp dataHoraInclusao;

	@Getter
	@Setter
	@Column(name="desc_chamado")
	private String descChamado;

	@Getter
	@Setter
	@Column(name="desc_titulo_chamado")
	private String descTituloChamado;

	//bi-directional many-to-one association to FilaChamado
	@ManyToOne
	@JoinColumn(name="cod_fila_chamado")
	private FilaChamado filaChamado;

	//bi-directional many-to-one association to Usuario
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="id_usuario_responsavel")
	private Usuario usuarioResponsavel;

	//bi-directional many-to-one association to Usuario
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="id_usuario_solicitante")
	private Usuario usuarioSolicitante;

	//bi-directional many-to-one association to StatusChamado
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="cod_status_chamado")
	private StatusChamado statusChamado;
}