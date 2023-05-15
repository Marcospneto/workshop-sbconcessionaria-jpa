package br.com.jvm.sbconcessionaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jvm.sbconcessionaria.model.entidade.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {

}
