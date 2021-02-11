package br.com.packtudo.demo.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Data
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

}