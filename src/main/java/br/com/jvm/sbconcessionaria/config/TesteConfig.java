package br.com.jvm.sbconcessionaria.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.jvm.sbconcessionaria.model.entidade.Cliente;
import br.com.jvm.sbconcessionaria.model.entidade.Financeiro;
import br.com.jvm.sbconcessionaria.model.entidade.Funcionario;
import br.com.jvm.sbconcessionaria.model.entidade.Veiculo;
import br.com.jvm.sbconcessionaria.model.entidade.Venda;
import br.com.jvm.sbconcessionaria.model.repositories.ClienteRepositorio;
import br.com.jvm.sbconcessionaria.model.repositories.FinanceiroRepositorio;
import br.com.jvm.sbconcessionaria.model.repositories.FuncionarioRepositorio;
import br.com.jvm.sbconcessionaria.model.repositories.VeiculoRepositorio;
import br.com.jvm.sbconcessionaria.model.repositories.VendaRepositorio;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
    @Autowired
	private ClienteRepositorio clienteRepositorio;
    @Autowired
    private FinanceiroRepositorio financeiroRepositorio;
    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;
    @Autowired
    private VeiculoRepositorio veiculoRepositorio;
    @Autowired
    private VendaRepositorio vendaRepositorio;
    

	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new Cliente(null, "Marcos", "09565015409" , "30/10/20");
		Cliente c2 = new Cliente(null, "Larissa", "11899755489" , "20/10/15");
		clienteRepositorio.saveAll(Arrays.asList(c1, c2));
		
		Financeiro f1 = new Financeiro(null, "700.000,00", "387.000,00", "22/10/2020 - 17.000,00");
		Financeiro f2 = new Financeiro(null, "700.000,00", "387.000,00", "17/03/2022 - 7.850,00");
		financeiroRepositorio.saveAll(Arrays.asList(f1, f2));
		
		Funcionario fun1 = new Funcionario(null, "Rosangela", "Rua José do Patrocinio Nº100", "88012385", "1.300,00", "10/05/2016");
		Funcionario fun2 = new Funcionario(null, "Maria", "Rua Napoleão Nº200", "99076564", "1.300,00", "08/03/2019");
		funcionarioRepositorio.saveAll(Arrays.asList(fun1, fun2));
		
		Veiculo v1 = new Veiculo(null, "Toyota", "Corolla", "2023", "Preto", 17500000);
		Veiculo v2 = new Veiculo(null, "Toyota", "Hilux", "2023", "Prata", 35000000);
		Veiculo v3 = new Veiculo(null, "Toyota", "Etios", "2023", "Vermelho", 8500000);

		veiculoRepositorio.saveAll(Arrays.asList(v1, v2, v3));
		
		Venda ven1 = new Venda(null, "10/10/2000", "175.000,00", "Dinheiro", "Rafael", c2);
		Venda ven2 = new Venda(null, "08/04/2023", "350.000,00", "Dinheiro", "Rosangela",c1 );
		vendaRepositorio.saveAll(Arrays.asList(ven1, ven2));
		
		
		
	}
}
