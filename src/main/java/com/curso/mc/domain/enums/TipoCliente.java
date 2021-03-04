package com.curso.mc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	// Atributos
	private int cod;
	private String descricao;
	
	// Construtor
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	// Get
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static  TipoCliente toEnum(Integer cod) {
		if(cod == null)
		{
			return null;
		}
		
		for(TipoCliente x : TipoCliente.values())
		{
			if(cod.equals(x.getCod()))
			{
				return x;
			}
		}
		
		throw new IllegalArgumentException("id inválido: " + cod);
	}
}
