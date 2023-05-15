package br.com.jvm.sbconcessionaria.model.entidade;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String datavenda;
	private String valortotalvenda;
	private String formapagamento;
	private String vendedor;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Venda() {

	}

	

	public Venda(Long id, String datavenda, String valortotalvenda, String formapagamento, String vendedor,
			Cliente cliente) {
		super();
		this.id = id;
		this.datavenda = datavenda;
		this.valortotalvenda = valortotalvenda;
		this.formapagamento = formapagamento;
		this.vendedor = vendedor;
		this.setCliente(cliente);
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDatavenda() {
		return datavenda;
	}

	public void setDatavenda(String datavenda) {
		this.datavenda = datavenda;
	}

	public String getValortotalvenda() {
		return valortotalvenda;
	}

	public void setValortotalvenda(String valortotalvenda) {
		this.valortotalvenda = valortotalvenda;
	}

	public String getFormapagamento() {
		return formapagamento;
	}

	public void setFormapagamento(String formapagamento) {
		this.formapagamento = formapagamento;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	

}
