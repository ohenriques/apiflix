package com.opeh.flix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opeh.flix.model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

	Optional<CategoriaModel> findById(long id);
}
