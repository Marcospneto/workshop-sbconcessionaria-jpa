package br.com.jvm.sbconcessionaria.model.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jvm.sbconcessionaria.model.entidade.Empresa;
import br.com.jvm.sbconcessionaria.model.repositories.EmpresaRepositorio;

@Service
public class EmpresaServico {

	@Autowired
	private EmpresaRepositorio repositorio;

	public List<Empresa> findAll() {
		return repositorio.findAll();
	}

	public Empresa findById(Long id) {
		Optional<Empresa> obj = repositorio.findById(id);
		return obj.get();
	}

	public Empresa insert(Empresa obj) {
		return repositorio.save(obj);
	}

	public void delete(Long id) {
		repositorio.deleteById(id);
	}

	public Empresa update(Long id, Empresa obj) {
		Empresa entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);

	}

	private void updateData(Empresa entity, Empresa obj) {
		entity.setCnpj(obj.getCnpj());
		entity.setRazaosocial(obj.getRazaosocial());
	}

}
