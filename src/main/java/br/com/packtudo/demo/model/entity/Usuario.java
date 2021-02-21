package br.com.packtudo.demo.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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
	@Getter
	@Setter
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer idUsuario;

	@Getter
	@Setter
	@Column(name="bol_ativo")
	private byte bolAtivo;

	@Getter
	@Setter
	@Column(name="data_hora_inclusao")
	private Timestamp dataHoraInclusao;

	@Getter
	@Setter
	@Column(name="desc_login")
	private String descLogin;

	@Getter
	@Setter
	@Column(name="desc_senha")
	private String descSenha;

	@Getter
	@Setter
	@OneToOne(mappedBy="usuario", cascade = CascadeType.REMOVE)
	private PerfilUsuario perfilUsuario;

	@Getter
	@Setter
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

	@Getter
	@Setter
	@OneToMany(mappedBy="usuarioResponsavel")
	private List<Chamado> chamadosUsuarioResponsavel;

	@Getter
	@Setter
	@OneToMany(mappedBy="usuarioSolicitante")
	private List<Chamado> chamadosUsuarioSolicitante;

}