package br.com.jvm.sbconcessionaria.model.estruturas;

import org.springframework.stereotype.Component;

import br.com.jvm.sbconcessionaria.model.entidade.Cliente;
@Component
public class ListaEncadeada {
	private No primeiro;
	private No ultimo;
	
	
	
	public ListaEncadeada() {
		this.primeiro = primeiro;
		this.ultimo = ultimo;
	}
	
	public void inserir (Cliente cliente) {
		No novoNo = new No(cliente);
		if (primeiro == null) {
			primeiro = novoNo;
			ultimo = novoNo;
		}else {
			ultimo.setProximo(novoNo);
			ultimo = novoNo;
		}
	}

	public No getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(No primeiro) {
		this.primeiro = primeiro;
	}

	public No getUltimo() {
		return ultimo;
	}

	public void setUltimo(No ultimo) {
		this.ultimo = ultimo;
	}

	
	
	
	

}
