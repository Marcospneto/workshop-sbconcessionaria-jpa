package br.com.jvm.sbconcessionaria.model.entidade;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = " Campo nome é obrigatorio!")
	private String nome;
	@NotBlank(message = " Campo endereço é obrigatorio!")
	private String endereco;
	@NotBlank(message = " Campo contato é obrigatorio!")
	private String contato;
	@NotBlank(message = " Campo salario é obrigatorio!")
	private String salario;
	@NotBlank(message = " Campo dataadmissao é obrigatorio!")
	private String dataadmissao;

	public Funcionario() {

	}

	public Funcionario(Long id, String nome, String endereco, String contato, String salario, String dataadmissao) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.salario = salario;
		this.dataadmissao = dataadmissao;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getDataadmissao() {
		return dataadmissao;
	}

	public void setDataadmissao(String dataadmissao) {
		this.dataadmissao = dataadmissao;
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
