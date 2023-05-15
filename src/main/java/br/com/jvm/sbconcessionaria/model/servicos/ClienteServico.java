package br.com.jvm.sbconcessionaria.model.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jvm.sbconcessionaria.model.entidade.Cliente;
import br.com.jvm.sbconcessionaria.model.repositories.ClienteRepositorio;
@Service
public class ClienteServico {
	
	//INSTANCIA DO REPOSITORIO PARA LIGAR O SERVICO COM O REPOSITORIO
	@Autowired
	private ClienteRepositorio repositorio;
	
	//METODO PARA LISTAR CLIENTE
	public List <Cliente> findAll(){
		return repositorio.findAll();
		}
	
	//METODO PARA PROCURAR CLIENTE POR ID
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repositorio.findById(id);
		return obj.get();
	}
	
	//METODO PARA INSERIR CLIENTE
	public Cliente insert (Cliente obj) {
		return repositorio.save(obj);
	}
	
	//METODO PARA DELETAR CLIENTE
	public void delete(Long id) {
		repositorio.deleteById(id);
	}
	
	// METODOS PARA ATUALIZAR CLIENTE
	public Cliente update (Long id, Cliente obj) {
		Cliente entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
		entity.setDatacadastro(obj.getDatacadastro());
		
	}
}
