package com.opeh.flix.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

import com.opeh.flix.model.VideoModel;
import com.opeh.flix.repository.VideoRepository;


@RestController
@RequestMapping
public class VideoController {

//	DEPENDENCI INJECTION JPA
	@Autowired
	VideoRepository videoRepository;

//  BUSCANDO TODOS OS VÍDEOS COM TRATAMENTO CASO NÃO SEJA ENCONTRADO = ERRO 404
	@GetMapping("/videos")
	public ResponseEntity<List<VideoModel>> getAllVideos() {
		List<VideoModel> videoList = videoRepository.findAll();
		if (videoList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			for (VideoModel video : videoList) {
				Long id = video.getId();
				video.add(linkTo(methodOn(VideoController.class).getOneVideo(id)).withSelfRel());
			}
			return new ResponseEntity<List<VideoModel>>(videoList, HttpStatus.OK);
		}
	}

//	BUSCANDO UM ÚNICO VÍDEO E TRATANDO CASO NÃO SEJA ENCONTRADO = ERRO 404
	@GetMapping("/video/{id}")
	public ResponseEntity<VideoModel> getOneVideo(@PathVariable(value = "id") long id) {
		Optional<VideoModel> videoUnico = videoRepository.findById(id);
		if (!videoUnico.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			videoUnico.get().add(linkTo(methodOn(VideoController.class).getAllVideos()).withRel("Lista de Vídeos"));
			return new ResponseEntity<VideoModel>(videoUnico.get(), HttpStatus.OK);
		
		}
	}

	// INSERINDO UM NOVO VÍDEO CASO SEJA CRIADO COM SUCESSO = STATUS 201
	@PostMapping("/video")
	public ResponseEntity<VideoModel> inserindoUmNovoVideo(@Valid @RequestBody VideoModel video) {
		return new ResponseEntity<VideoModel>(videoRepository.save(video), HttpStatus.CREATED);
	}

//	DELETANDO UM VÍDEO
	@DeleteMapping("/video/{id}")
	public ResponseEntity<?> deletarUmVideo(@PathVariable(value = "id") long id) {
		Optional<VideoModel> video = videoRepository.findById(id);
		if (!video.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			videoRepository.delete(video.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

//	ATUALIZANDO UM VIDEO
	@PutMapping("/video/{id}")
	@Transactional
	public ResponseEntity<VideoModel> atualizaUmVideo(@PathVariable(value = "id") long id,
			@RequestBody @Valid VideoModel video) {
		Optional<VideoModel> videoO = videoRepository.findById(id);
		if (!videoO.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			video.setId(videoO.get().getId());
			return new ResponseEntity<VideoModel>(videoRepository.save(video), HttpStatus.OK);

		}
	}

//	#################### \/ SEM RETORNOS DE STATUS CODE \/

//// BUSCANDO TODOS OS VÍDEOS SEM TRATAMENTO DE ERRO 404

//	@GetMapping("/videos")
//	public List<Video> listaVideos() {
//		return videoRepository.findAll();
//	}

////	BUSCANDO UM ÚNICO VÍDEO

//	@GetMapping("/video/{id}")
//	public Video buscaUnicoVideo(@PathVariable(value = "id") long id) {
//		return videoRepository.findById(id);
//	}

//	INSERINDO UM NOVO VÍDEO

//	@PostMapping("/video")
//	public Video inserindoUmNovoVideo(@Valid @RequestBody Video video) {
//		return videoRepository.save(video);
//	}

//	ATUALIZANDO UM VIDEO

//	@PutMapping("/video")
//	@Transactional
//	public Video atualizaUmVideo(@RequestBody Video video) {
//		return videoRepository.save(video);
//	}

//	DELETANDO UM VÍDEO

//	@DeleteMapping("/video")
//	public void deletarUmVideo(@RequestBody Video video) {
//		videoRepository.delete(video);
//	}

//	DELETE VIDEO SECCOND METHOD2 DELETING VIDEO BY ID IN URI

//	@DeleteMapping("/video/{id}")
//	public void deletarUmVideo(@PathVariable(value = "id") long id) {
//		videoRepository.deleteById(id);
//	}

}
