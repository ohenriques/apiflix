package com.opeh.flix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opeh.flix.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{

	Optional<Video> findById(long id);
	
}

