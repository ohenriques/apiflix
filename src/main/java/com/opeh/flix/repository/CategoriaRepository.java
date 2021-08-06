package com.opeh.flix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opeh.flix.model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

	CategoriaModel findByTitulo(String titulo);
}
