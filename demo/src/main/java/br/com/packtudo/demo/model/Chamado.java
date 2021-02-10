package br.com.packtudo.demo.model;

import java.io.Serializable;
import javax.persistence.*;
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

	@Column(name="id_usuario_responsavel")
	private Integer idUsuarioResponsavel;

	//bi-directional many-to-one association to FilaChamado
	@ManyToOne
	@JoinColumn(name="cod_fila_chamado")
	private FilaChamado filaChamado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_solicitante")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_solicitante")
	private Usuario usuario2;

	//bi-directional many-to-one association to StatusChamado
	@ManyToOne
	@JoinColumn(name="cod_status_chamado")
	private StatusChamado statusChamado;

	public Chamado() {
	}

	public Integer getIdChamado() {
		return this.idChamado;
	}

	public void setIdChamado(Integer idChamado) {
		this.idChamado = idChamado;
	}

	public Timestamp getDataHoraEncerramento() {
		return this.dataHoraEncerramento;
	}

	public void setDataHoraEncerramento(Timestamp dataHoraEncerramento) {
		this.dataHoraEncerramento = dataHoraEncerramento;
	}

	public Timestamp getDataHoraInclusao() {
		return this.dataHoraInclusao;
	}

	public void setDataHoraInclusao(Timestamp dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}

	public String getDescChamado() {
		return this.descChamado;
	}

	public void setDescChamado(String descChamado) {
		this.descChamado = descChamado;
	}

	public String getDescTituloChamado() {
		return this.descTituloChamado;
	}

	public void setDescTituloChamado(String descTituloChamado) {
		this.descTituloChamado = descTituloChamado;
	}

	public Integer getIdUsuarioResponsavel() {
		return this.idUsuarioResponsavel;
	}

	public void setIdUsuarioResponsavel(Integer idUsuarioResponsavel) {
		this.idUsuarioResponsavel = idUsuarioResponsavel;
	}

	public FilaChamado getFilaChamado() {
		return this.filaChamado;
	}

	public void setFilaChamado(FilaChamado filaChamado) {
		this.filaChamado = filaChamado;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

	public StatusChamado getStatusChamado() {
		return this.statusChamado;
	}

	public void setStatusChamado(StatusChamado statusChamado) {
		this.statusChamado = statusChamado;
	}

}