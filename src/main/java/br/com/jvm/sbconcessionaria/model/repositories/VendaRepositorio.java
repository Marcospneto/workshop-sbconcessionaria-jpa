package br.com.jvm.sbconcessionaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jvm.sbconcessionaria.model.entidade.Venda;

public interface VendaRepositorio extends JpaRepository<Venda, Long> {

}
