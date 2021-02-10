package br.com.packtudo.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="bol_ativo")
	private Integer bolAtivo;

	@Column(name="data_hora_inclusao")
	private Timestamp dataHoraInclusao;

	@Column(name="desc_login")
	private String descLogin;

	@Column(name="desc_senha")
	private String descSenha;

	//bi-directional one-to-one association to PerfilUsuario
	@OneToOne(mappedBy="usuario")
	private PerfilUsuario perfilUsuario;

	//bi-directional many-to-many association to GrupoPermissao
	@ManyToMany
	@JoinTable(
		name="usuario_grupo_permissao"
		, joinColumns={
			@JoinColumn(name="id_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="cod_grupo_permissao")
			}
		)
	private List<GrupoPermissao> grupoPermissaos;

	//bi-directional many-to-one association to Chamado
	@OneToMany(mappedBy="usuario1")
	private List<Chamado> chamados1;

	//bi-directional many-to-one association to Chamado
	@OneToMany(mappedBy="usuario2")
	private List<Chamado> chamados2;

	public Usuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getBolAtivo() {
		return this.bolAtivo;
	}

	public void setBolAtivo(Integer bolAtivo) {
		this.bolAtivo = bolAtivo;
	}

	public Timestamp getDataHoraInclusao() {
		return this.dataHoraInclusao;
	}

	public void setDataHoraInclusao(Timestamp dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}

	public String getDescLogin() {
		return this.descLogin;
	}

	public void setDescLogin(String descLogin) {
		this.descLogin = descLogin;
	}

	public String getDescSenha() {
		return this.descSenha;
	}

	public void setDescSenha(String descSenha) {
		this.descSenha = descSenha;
	}

	public PerfilUsuario getPerfilUsuario() {
		return this.perfilUsuario;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public List<GrupoPermissao> getGrupoPermissaos() {
		return this.grupoPermissaos;
	}

	public void setGrupoPermissaos(List<GrupoPermissao> grupoPermissaos) {
		this.grupoPermissaos = grupoPermissaos;
	}

	public List<Chamado> getChamados1() {
		return this.chamados1;
	}

	public void setChamados1(List<Chamado> chamados1) {
		this.chamados1 = chamados1;
	}

	public Chamado addChamados1(Chamado chamados1) {
		getChamados1().add(chamados1);
		chamados1.setUsuario1(this);

		return chamados1;
	}

	public Chamado removeChamados1(Chamado chamados1) {
		getChamados1().remove(chamados1);
		chamados1.setUsuario1(null);

		return chamados1;
	}

	public List<Chamado> getChamados2() {
		return this.chamados2;
	}

	public void setChamados2(List<Chamado> chamados2) {
		this.chamados2 = chamados2;
	}

	public Chamado addChamados2(Chamado chamados2) {
		getChamados2().add(chamados2);
		chamados2.setUsuario2(this);

		return chamados2;
	}

	public Chamado removeChamados2(Chamado chamados2) {
		getChamados2().remove(chamados2);
		chamados2.setUsuario2(null);

		return chamados2;
	}

}