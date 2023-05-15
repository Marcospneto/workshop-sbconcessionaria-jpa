package br.com.jvm.sbconcessionaria.model.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jvm.sbconcessionaria.model.entidade.Financeiro;
import br.com.jvm.sbconcessionaria.model.repositories.FinanceiroRepositorio;
@Service
public class FinanceiroServico {
	
	@Autowired
	private FinanceiroRepositorio repositorio;

	public List<Financeiro> findAll() {
		return repositorio.findAll();
	}
	
	public Financeiro findById(Long id) {
		Optional<Financeiro> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public Financeiro insert (Financeiro obj) {
		return repositorio.save(obj);
	}
	
	public void delete (Long id) {
		repositorio.deleteById(id);
	}
	
	public Financeiro update (Long id, Financeiro obj) {
		Financeiro entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(Financeiro entity, Financeiro obj) {
		entity.setReceita(obj.getReceita());
		entity.setDespesa(obj.getDespesa());
		entity.setContabilidade(obj.getContabilidade());
		
		
	}
}
