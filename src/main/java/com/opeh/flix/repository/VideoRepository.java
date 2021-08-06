package com.opeh.flix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opeh.flix.model.VideoModel;

public interface VideoRepository extends JpaRepository<VideoModel, Long>{

	Optional<VideoModel> findById(long id);
	
}

