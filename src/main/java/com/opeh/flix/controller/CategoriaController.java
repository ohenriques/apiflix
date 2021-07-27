package com.opeh.flix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opeh.flix.model.CategoriaModel;
import com.opeh.flix.repository.CategoriaRepository;

@RestController
@RequestMapping
public class CategoriaController {

// DEPENDENCI INJECTION JPA
	@Autowired
	CategoriaRepository categoriaRepository;
	
//	BUSCANDO TODOS OS VÍDEOS
	@GetMapping("/categorias/")
	public List<CategoriaModel> listaCategorias(){
		return categoriaRepository.findAll();
	}
}
