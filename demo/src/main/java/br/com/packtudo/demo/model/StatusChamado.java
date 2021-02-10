package br.com.packtudo.demo.model;

import java.io.Serializable;
import javax.persistence.*;
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
	private Integer codStatusChamado;

	@Column(name="desc_status_chamado")
	private String descStatusChamado;

	//bi-directional many-to-one association to Chamado
	@OneToMany(mappedBy="statusChamado")
	private List<Chamado> chamados;

	public StatusChamado() {
	}

	public Integer getCodStatusChamado() {
		return this.codStatusChamado;
	}

	public void setCodStatusChamado(Integer codStatusChamado) {
		this.codStatusChamado = codStatusChamado;
	}

	public String getDescStatusChamado() {
		return this.descStatusChamado;
	}

	public void setDescStatusChamado(String descStatusChamado) {
		this.descStatusChamado = descStatusChamado;
	}

	public List<Chamado> getChamados() {
		return this.chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	public Chamado addChamado(Chamado chamado) {
		getChamados().add(chamado);
		chamado.setStatusChamado(this);

		return chamado;
	}

	public Chamado removeChamado(Chamado chamado) {
		getChamados().remove(chamado);
		chamado.setStatusChamado(null);

		return chamado;
	}

}