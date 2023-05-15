package br.com.jvm.sbconcessionaria.model.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jvm.sbconcessionaria.model.entidade.Funcionario;
import br.com.jvm.sbconcessionaria.model.repositories.FuncionarioRepositorio;

@Service
public class FuncionarioServico {

	@Autowired
	private FuncionarioRepositorio repositorio;

	public List<Funcionario> findAll() {
		return repositorio.findAll();
	}

	public Funcionario findById(Long id) {
		Optional<Funcionario> obj = repositorio.findById(id);
		return obj.get();
	}

	public Funcionario insert(Funcionario obj) {
		return repositorio.save(obj);
	}

	public void delete(Long id) {
		repositorio.deleteById(id);
	}
	
	public Funcionario update (Long id, Funcionario obj) {
		Funcionario entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(Funcionario entity, Funcionario obj) {
		entity.setNome(obj.getNome());
		entity.setEndereco(obj.getEndereco());
		entity.setContato(obj.getContato());
		entity.setSalario(obj.getSalario());
		entity.setDataadmissao(obj.getDataadmissao());
		
	}

}
