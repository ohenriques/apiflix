package com.opeh.flix.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opeh.flix.model.VideoModel;

public interface VideoRepository extends JpaRepository<VideoModel, Long>{

	Optional<VideoModel> findById(long id);

	VideoModel saveAll(@Valid VideoModel video, Long id);

	
}

