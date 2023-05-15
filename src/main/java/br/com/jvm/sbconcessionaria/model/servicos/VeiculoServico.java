package br.com.jvm.sbconcessionaria.model.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jvm.sbconcessionaria.model.entidade.Veiculo;
import br.com.jvm.sbconcessionaria.model.repositories.VeiculoRepositorio;

@Service
public class VeiculoServico {

	@Autowired
	private VeiculoRepositorio repositorio;

	public List<Veiculo> findAll() {
		return repositorio.findAll();
	}

	public Veiculo findById(Long id) {
		Optional<Veiculo> obj = repositorio.findById(id);
		return obj.get();
	}

	public Veiculo insert(Veiculo obj) {
		return repositorio.save(obj);
	}

	public void delete(Long id) {
		repositorio.deleteById(id);
	}
	
	public Veiculo update(Long id, Veiculo obj) {
		Veiculo entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}	
		
	
	private void updateData(Veiculo entity, Veiculo obj) {
		entity.setMarca(obj.getMarca());
		entity.setModelo(obj.getModelo());
		entity.setAno(obj.getAno());
		entity.setCor(obj.getCor());
		entity.setValor(obj.getValor());
		
	}

}
