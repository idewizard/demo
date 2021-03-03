package br.com.packtudo.gaia.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the status_chamado database table.
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="status_chamado")
@NamedQuery(name="StatusChamado.findAll", query="SELECT s FROM StatusChamado s")
public class StatusChamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_status_chamado")
	private short codStatusChamado;

	@Getter
	@Setter
	@Column(name="desc_status_chamado")
	private String descStatusChamado;

	//bi-directional many-to-one association to Chamado
	@OneToMany(mappedBy="statusChamado")
	private List<Chamado> chamados;

	public static StatusChamado of(short codStatusChamado, String descStatusChamado){
		return new StatusChamado(codStatusChamado, descStatusChamado, null);
	}

}