package br.com.jvm.sbconcessionaria.control.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jvm.sbconcessionaria.model.entidade.Funcionario;
import br.com.jvm.sbconcessionaria.model.servicos.FuncionarioServico;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioServico servico;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll(){
		List<Funcionario> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable Long id){
		Funcionario obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Funcionario> insert (@Valid @RequestBody Funcionario obj){
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Funcionario> update (@PathVariable Long id, @RequestBody Funcionario obj){
		obj = servico.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
