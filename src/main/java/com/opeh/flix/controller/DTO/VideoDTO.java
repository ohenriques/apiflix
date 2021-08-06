package com.opeh.flix.controller.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.opeh.flix.model.VideoModel;

public class VideoDTO {

	private Long id;
	private String titulo;
	private String url;

	public VideoDTO(VideoModel videoModel) {
		this.id = videoModel.getId();
		this.titulo = videoModel.getTitulo();
		this.url = videoModel.getUrl();	
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getUrl() {
		return url;
	}

	public static List<VideoDTO> converter(List<VideoModel> videos) {
		return videos.stream().map(VideoDTO::new).collect(Collectors.toList());
	}

}
