package com.curso.mc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.curso.mc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	
	// Subclasse precisa do número de versão
	private static final long serialVersionUID = 1L;
	
	// Atributos básicos
	private Date dataVencimento;
	private Date dataPagamento;
	
	// Construtor vazio
	public PagamentoComBoleto() {}

	// Construtor
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	// Gets e Sets
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	// Não precisa de hashCode e Equals por conter na classe pai

}
