package com.opeh.flix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opeh.flix.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{

	Video findById(long id);
	
}
