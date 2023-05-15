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

import br.com.jvm.sbconcessionaria.model.entidade.Financeiro;
import br.com.jvm.sbconcessionaria.model.servicos.FinanceiroServico;

@RestController
@RequestMapping(value = "/financeiro")
public class FinanceiroResource {
	
	@Autowired
	private FinanceiroServico servico;
	
	@GetMapping
	public ResponseEntity<List<Financeiro>> findAll(){
		List<Financeiro> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Financeiro> findById(@PathVariable Long id){
		Financeiro obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Financeiro> insert (@RequestBody Financeiro obj){
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id})")
				.buildAndExpand(obj.getId()).toUri();
				return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> delete (@PathVariable Long id){
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Financeiro> update (@PathVariable Long id, @RequestBody Financeiro obj){
		obj = servico.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
