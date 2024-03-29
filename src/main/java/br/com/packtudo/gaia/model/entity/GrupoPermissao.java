package br.com.packtudo.gaia.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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
	@Getter
	@Setter
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_grupo_permissao")	
	private short codGrupoPermissao;

	@Column(name="data_hora_inclusao")
	private Timestamp dataHoraInclusao;
	
	@Getter
	@Setter
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


}