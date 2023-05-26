package br.com.jvm.sbconcessionaria.model.entidade;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Financeiro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = " Campo receita é obrigatorio!")
	private String receita;
	@NotBlank(message = " Campo despesa é obrigatorio!")
	private String despesa;
	@NotBlank(message = " Campo contabilidade é obrigatorio!")
	private String contabilidade;

	public Financeiro() {

	}

	public Financeiro(Long id, String receita, String despesa, String contabilidade) {
		super();
		this.id = id;
		this.receita = receita;
		this.despesa = despesa;
		this.contabilidade = contabilidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReceita() {
		return receita;
	}

	public void setReceita(String receita) {
		this.receita = receita;
	}

	public String getDespesa() {
		return despesa;
	}

	public void setDespesa(String despesa) {
		this.despesa = despesa;
	}

	public String getContabilidade() {
		return contabilidade;
	}

	public void setContabilidade(String contabilidade) {
		this.contabilidade = contabilidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Financeiro other = (Financeiro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
