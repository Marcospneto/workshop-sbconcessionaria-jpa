package br.com.jvm.sbconcessionaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jvm.sbconcessionaria.model.entidade.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
