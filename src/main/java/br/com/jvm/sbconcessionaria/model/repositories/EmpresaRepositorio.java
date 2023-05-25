package br.com.jvm.sbconcessionaria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jvm.sbconcessionaria.model.entidade.Empresa;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {

}
