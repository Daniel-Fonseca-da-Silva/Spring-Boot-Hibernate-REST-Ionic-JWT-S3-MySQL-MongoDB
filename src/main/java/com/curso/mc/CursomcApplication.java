package com.curso.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.mc.domain.Categoria;
import com.curso.mc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository categoriaRepository;

	public static void main(String[] args) 
	{
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		
		// Cria objetos
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		
		// Salva no BD
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}
	
	

}
