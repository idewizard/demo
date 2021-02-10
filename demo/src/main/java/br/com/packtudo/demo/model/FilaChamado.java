package br.com.packtudo.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the fila_chamado database table.
 * 
 */
@Entity
@Table(name="fila_chamado")
@NamedQuery(name="FilaChamado.findAll", query="SELECT f FROM FilaChamado f")
public class FilaChamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_fila_chamado")
	private Integer codFilaChamado;

	@Column(name="data_hora_inclusao")
	private Timestamp dataHoraInclusao;

	@Column(name="desc_fila_chamado")
	private String descFilaChamado;

	//bi-directional many-to-many association to GrupoPermissao
	@ManyToMany(mappedBy="filaChamados")
	private List<GrupoPermissao> grupoPermissaos;

	//bi-directional many-to-one association to Chamado
	@OneToMany(mappedBy="filaChamado")
	private List<Chamado> chamados;

	public FilaChamado() {
	}

	public Integer getCodFilaChamado() {
		return this.codFilaChamado;
	}

	public void setCodFilaChamado(Integer codFilaChamado) {
		this.codFilaChamado = codFilaChamado;
	}

	public Timestamp getDataHoraInclusao() {
		return this.dataHoraInclusao;
	}

	public void setDataHoraInclusao(Timestamp dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}

	public String getDescFilaChamado() {
		return this.descFilaChamado;
	}

	public void setDescFilaChamado(String descFilaChamado) {
		this.descFilaChamado = descFilaChamado;
	}

	public List<GrupoPermissao> getGrupoPermissaos() {
		return this.grupoPermissaos;
	}

	public void setGrupoPermissaos(List<GrupoPermissao> grupoPermissaos) {
		this.grupoPermissaos = grupoPermissaos;
	}

	public List<Chamado> getChamados() {
		return this.chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	public Chamado addChamado(Chamado chamado) {
		getChamados().add(chamado);
		chamado.setFilaChamado(this);

		return chamado;
	}

	public Chamado removeChamado(Chamado chamado) {
		getChamados().remove(chamado);
		chamado.setFilaChamado(null);

		return chamado;
	}

}