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

import br.com.jvm.sbconcessionaria.model.entidade.Cliente;
import br.com.jvm.sbconcessionaria.model.estruturas.ListaEncadeada;
import br.com.jvm.sbconcessionaria.model.estruturas.No;
import br.com.jvm.sbconcessionaria.model.servicos.ClienteServico;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/client") // ENDERECO QUE SERÀ ULTILIZANDO PARA MAPEAR OS CLIENTES
public class ClienteResource {

	// INSTANCIA DO CONTROLADOR PARA O SERVICO PARA QUE 1 SE COMUNIQUE COM A OUTRA
	@Autowired
	private ClienteServico servico;
	@Autowired
	private ListaEncadeada listaEncadeada;

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Cliente> insert(@Valid @RequestBody Cliente obj) {
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente obj) {
		obj = servico.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/listaencadeada/primeirono")
	public ResponseEntity<Cliente> getPrimeiroNoListaEncadeada() {
		No primeiroNo = listaEncadeada.getPrimeiro();
		Cliente primeiroCliente = primeiroNo != null ? primeiroNo.getCliente():null;
		return ResponseEntity.ok(primeiroCliente);
	}

	@GetMapping("/listaencadeada/ultimono")
	public ResponseEntity<Cliente> getUltimoNoListaEncadeada() {
		No ultimoNo = listaEncadeada.getUltimo();
		Cliente ultimoCliente = ultimoNo != null ? ultimoNo.getCliente():null;
		return ResponseEntity.ok(ultimoCliente);
	}

}
