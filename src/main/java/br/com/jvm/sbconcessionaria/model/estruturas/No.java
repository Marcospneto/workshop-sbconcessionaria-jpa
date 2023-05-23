package br.com.jvm.sbconcessionaria.model.estruturas;

import br.com.jvm.sbconcessionaria.model.entidade.Cliente;

public class No {

	private Cliente cliente;
	private No proximo;

	public No(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	@Override
	public String toString() {
		return "No [cliente=" + cliente + ", proximo=" + proximo + "]";
	}

}
