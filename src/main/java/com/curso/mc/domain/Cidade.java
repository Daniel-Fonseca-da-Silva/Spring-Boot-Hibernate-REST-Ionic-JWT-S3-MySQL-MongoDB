package com.curso.mc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cidade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id // Mapeamento
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Mapeamento
	// Atributos
	private Integer id;
	private String cidade;
	
	@JsonManagedReference // Habilita Serialização
	
	@ManyToOne // Mapeamento da Cidade para Estado
	@JoinColumn(name = "estado_id") // Nome da chave estrangeira que conecta Estado com Cidade
	
	// Associação com Estado
	private Estado estado;

	// Construtor vazio
	public Cidade() {
		super();
	}
	
	// Construtor
	public Cidade(Integer id, String cidade, Estado estado) {
		super();
		this.id = id;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	// Gets e Sets

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	// hashCode e Equals somente id
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}
	
}
