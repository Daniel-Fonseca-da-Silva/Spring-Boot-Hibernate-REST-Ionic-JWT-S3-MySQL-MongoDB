package com.curso.mc.domain;

import javax.persistence.Entity;

import com.curso.mc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	
	// Subclasse precisa do número de versão
	private static final long serialVersionUID = 1L;
	
	// Atributos básicos
	private Integer numeroDeParcelas;
	
	// Construtor vazio
	public PagamentoComCartao() {}

	// Construtor
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	// Gets e Sets
	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	};
	
	// Não precisa de hashCode e Equals por conter na classe pai

}
