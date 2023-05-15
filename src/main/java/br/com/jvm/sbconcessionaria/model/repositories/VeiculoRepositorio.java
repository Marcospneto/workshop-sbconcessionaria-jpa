package br.com.jvm.sbconcessionaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jvm.sbconcessionaria.model.entidade.Veiculo;

public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long>{

}
