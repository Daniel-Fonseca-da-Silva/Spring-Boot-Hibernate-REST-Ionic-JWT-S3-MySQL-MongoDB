package com.curso.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.mc.domain.Categoria;
import com.curso.mc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired // Instânciamento automático
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id)
	{
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
