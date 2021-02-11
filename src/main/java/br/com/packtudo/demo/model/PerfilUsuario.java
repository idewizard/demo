package br.com.packtudo.demo.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the perfil_usuario database table.
 * 
 */
@Data
@Entity
@Table(name="perfil_usuario")
@NamedQuery(name="PerfilUsuario.findAll", query="SELECT p FROM PerfilUsuario p")
public class PerfilUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil_usuario")
	private Integer idPerfilUsuario;

	@Column(name="data_hora_inclusao")
	private Timestamp dataHoraInclusao;

	@Column(name="desc_email")
	private String descEmail;

	@Column(name="desc_nome")
	private String descNome;

	@Column(name="desc_sobrenome")
	private String descSobrenome;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

}