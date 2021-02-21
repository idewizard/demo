package br.com.packtudo.demo.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the status_chamado database table.
 * 
 */
@Entity
@Table(name="status_chamado")
@NamedQuery(name="StatusChamado.findAll", query="SELECT s FROM StatusChamado s")
public class StatusChamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_status_chamado")
	private short codStatusChamado;

	@Column(name="desc_status_chamado")
	private String descStatusChamado;

	//bi-directional many-to-one association to Chamado
	@OneToMany(mappedBy="statusChamado")
	private List<Chamado> chamados;

}