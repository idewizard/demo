package br.com.packtudo.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the grupo_permissao database table.
 * 
 */
@Entity
@Table(name="grupo_permissao")
@NamedQuery(name="GrupoPermissao.findAll", query="SELECT g FROM GrupoPermissao g")
public class GrupoPermissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_grupo_permissao")
	private Integer codGrupoPermissao;

	@Column(name="data_hora_inclusao")
	private Timestamp dataHoraInclusao;

	@Column(name="desc_grupo_permissao")
	private String descGrupoPermissao;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="grupoPermissaos")
	private List<Usuario> usuarios;

	//bi-directional many-to-many association to FilaChamado
	@ManyToMany
	@JoinTable(
		name="grupo_permissao_fila_chamado"
		, joinColumns={
			@JoinColumn(name="cod_grupo_permissao")
			}
		, inverseJoinColumns={
			@JoinColumn(name="cod_fila_chamado")
			}
		)
	private List<FilaChamado> filaChamados;

	public GrupoPermissao() {
	}

	public Integer getCodGrupoPermissao() {
		return this.codGrupoPermissao;
	}

	public void setCodGrupoPermissao(Integer codGrupoPermissao) {
		this.codGrupoPermissao = codGrupoPermissao;
	}

	public Timestamp getDataHoraInclusao() {
		return this.dataHoraInclusao;
	}

	public void setDataHoraInclusao(Timestamp dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}

	public String getDescGrupoPermissao() {
		return this.descGrupoPermissao;
	}

	public void setDescGrupoPermissao(String descGrupoPermissao) {
		this.descGrupoPermissao = descGrupoPermissao;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<FilaChamado> getFilaChamados() {
		return this.filaChamados;
	}

	public void setFilaChamados(List<FilaChamado> filaChamados) {
		this.filaChamados = filaChamados;
	}

}