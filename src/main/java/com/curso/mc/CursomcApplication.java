package com.curso.mc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.mc.domain.Categoria;
import com.curso.mc.domain.Cidade;
import com.curso.mc.domain.Cliente;
import com.curso.mc.domain.Endereco;
import com.curso.mc.domain.Estado;
import com.curso.mc.domain.Pagamento;
import com.curso.mc.domain.PagamentoComBoleto;
import com.curso.mc.domain.PagamentoComCartao;
import com.curso.mc.domain.Pedido;
import com.curso.mc.domain.Produto;
import com.curso.mc.domain.enums.EstadoPagamento;
import com.curso.mc.domain.enums.TipoCliente;
import com.curso.mc.repositories.CategoriaRepository;
import com.curso.mc.repositories.CidadeRepository;
import com.curso.mc.repositories.ClienteRepository;
import com.curso.mc.repositories.EnderecoRepository;
import com.curso.mc.repositories.EstadoRepository;
import com.curso.mc.repositories.PagamentoRepository;
import com.curso.mc.repositories.PedidoRepository;
import com.curso.mc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) 
	{
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		
		// Cria objetos de Categoria
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		// Cria objetos de Produto
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
	
		// Cria objetos de Estado
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		// Cria objetos de Cidade
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		// Associação da categoria de cat1 com p1, p2, p3 de Produto
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		// Associação da categoria de cat2 com p2 de Produto
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		// Associação da categoria p1 de Produto com cat1 da Categoria
		p1.getCategorias().addAll(Arrays.asList(cat1));
		// Associação da categoria p1 de Produto com cat1, cat2 da Categoria
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		// Associação da categoria p3 de produto com cat1 da Categoria
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		// Salva no BD objetos de Categoria
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		// Salva no BD objetos de Produto
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		// Associação do Estado de est1 com c1 de Cidade
		est1.getCidades().addAll(Arrays.asList(c1));
		// Associação do Estado de est2 com c2, c3 de Cidade
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		// Salva no BD objetos de Estado
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		// Salva no BD objetos de Cidade
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		// Cria objetos de Cliente
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		// Cria objetos de Endereco
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		// Associação do Cliente de cli1 com Endereco e1, e2
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		// Salva no BD objetos de Cliente
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		// Salva no BD objetos de Endereco
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		// Cria objetos de Pedido
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		// Cria Objetos de Pagamento
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2,
		sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		// Salva no BD objetos Pedido
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		// Salva no BD objetos Pagamento
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
	}

}
