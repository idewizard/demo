package br.com.packtudo.demo.model;

import lombok.Data;

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
@Data
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

}