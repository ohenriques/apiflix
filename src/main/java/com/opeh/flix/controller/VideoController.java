package com.opeh.flix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opeh.flix.model.Video;
import com.opeh.flix.repository.VideoRepository;

@RestController
@RequestMapping
public class VideoController {

//	DEPENDENCI INJECTION JPA
	@Autowired
	VideoRepository videoRepository;

//	BUSCANDO TODOS OS VÍDEOS
	@GetMapping("/videos")
	public List<Video> listaVideos() {
		return videoRepository.findAll();
	}

//	BUSCANDO UM ÚNICO VÍDEO
	@GetMapping("/video/{id}")
	public Video buscaUnicoVideo(@PathVariable(value = "id") long id) {
		return videoRepository.findById(id);
	}

//	INSERINDO UM NOVO VÍDEO
	@PostMapping("/video")
	public Video inserindoUmNovoVideo(@Valid @RequestBody Video video) {
		return videoRepository.save(video);
	}

//	ATUALIZANDO UM VIDEO
	@PutMapping("/video")
	public Video atualizaUmVideo(@RequestBody Video video) {
		return videoRepository.save(video);
	}

//	DELETANDO UM VÍDEO
	@DeleteMapping("/video")
	public void deletarUmVideo(@RequestBody Video video) {
		videoRepository.delete(video);
	}

//	DELETE VIDEO SECCOND METHOD2 DELETING VIDEO BY ID IN URI
	@DeleteMapping("/video/{id}")
	public void deletarUmVideo(@PathVariable(value = "id") long id) {
		videoRepository.deleteById(id);
	}

}
