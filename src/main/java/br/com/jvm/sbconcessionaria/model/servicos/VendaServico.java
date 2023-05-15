package br.com.jvm.sbconcessionaria.model.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jvm.sbconcessionaria.model.entidade.Venda;
import br.com.jvm.sbconcessionaria.model.repositories.VendaRepositorio;

@Service
public class VendaServico {

	@Autowired
	private VendaRepositorio repositorio;

	public List<Venda> findAll() {
		return repositorio.findAll();
	}

	public Venda findById(Long id) {
		Optional<Venda> obj = repositorio.findById(id);
		return obj.get();
	}

	public Venda insert(Venda obj) {
		return repositorio.save(obj);
	}

	public void delete(Long id) {
		repositorio.deleteById(id);
	}
	
	public Venda update (Long id, Venda obj) {
		Venda entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(Venda entity, Venda obj) {
		entity.setVendedor(obj.getVendedor());
		entity.setFormapagamento(obj.getFormapagamento());
		entity.setDatavenda(obj.getDatavenda());
		entity.setValortotalvenda(obj.getValortotalvenda());
		
		
	}

}
