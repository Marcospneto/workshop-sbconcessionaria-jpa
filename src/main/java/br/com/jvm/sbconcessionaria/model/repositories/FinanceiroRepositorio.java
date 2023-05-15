package br.com.jvm.sbconcessionaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jvm.sbconcessionaria.model.entidade.Financeiro;

public interface FinanceiroRepositorio extends JpaRepository<Financeiro, Long> {

}
