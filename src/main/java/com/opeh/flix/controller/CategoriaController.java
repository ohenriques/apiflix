package com.opeh.flix.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

//  BUSCANDO TODOS OS VÍDEOS COM TRATAMENTO CASO NÃO SEJA ENCONTRADO = ERRO 404
	@GetMapping("/categorias/")
	public ResponseEntity<List<CategoriaModel>> getAllCategorias() {
		List<CategoriaModel> categoriaList = categoriaRepository.findAll();
		if (categoriaList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			for (CategoriaModel categoria : categoriaList) {
				Long id = categoria.getId();
				categoria.add(linkTo(methodOn(CategoriaController.class).getOneCategoria(id)).withSelfRel());
			}
			return new ResponseEntity<List<CategoriaModel>>(categoriaList, HttpStatus.OK);
		}
	}

//	BUSCANDO UM ÚNICO VÍDEO E TRATANDO CASO NÃO SEJA ENCONTRADO = ERRO 404
	@GetMapping("/categoria/{id}")
	public ResponseEntity<CategoriaModel> getOneCategoria(@PathVariable(value = "id") long id) {
		Optional<CategoriaModel> categUni = categoriaRepository.findById(id);
		if (!categUni.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		categUni.get().add(linkTo(methodOn(VideoController.class).getAllVideos()).withRel("Lista de Categorias"));
		return new ResponseEntity<CategoriaModel>(categUni.get(), HttpStatus.OK);
	}

// INSERINDO UM NOVO VÍDEO CASO SEJA CRIADO COM SUCESSO = STATUS 201
	@PostMapping("/categoria")
	public ResponseEntity<CategoriaModel> inserindoUmaNovaCategoria(@Valid @RequestBody CategoriaModel categoria) {
		return new ResponseEntity<CategoriaModel>(categoriaRepository.save(categoria), HttpStatus.CREATED);
	}

// ATUALIZANDO UM VIDEO
	@PutMapping("/categoria")
	@Transactional
	public ResponseEntity<CategoriaModel> atualizaUmaCategoria(@RequestBody @Valid CategoriaModel categoria) {
		Optional<CategoriaModel> categoriaA = categoriaRepository.findById(categoria.getId());
		if (!categoriaA.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			categoria.setId(categoriaA.get().getId());
			return new ResponseEntity<CategoriaModel>(categoriaRepository.save(categoria), HttpStatus.OK);
		}

	}

//	DELETANDO UMA CATEGORIA
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<?> deletarUmaCategoria(@PathVariable(value = "id") long id) {
		Optional<CategoriaModel> categoria = categoriaRepository.findById(id);
		if (!categoria.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			categoriaRepository.delete(categoria.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

}
