package com.opeh.flix.controller.Form;

import com.opeh.flix.model.CategoriaModel;
import com.opeh.flix.model.VideoModel;
import com.opeh.flix.repository.CategoriaRepository;

public class VideoForm {

//Classe java, POJO, JAVA BEAN,SÓ ATRIB, GET E SET

	private String titulo;
	private String descricao;
	private String url;
	private String tituloCategoria;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTituloCategoria() {
		return tituloCategoria;
	}

	public void setTituloCategoria(String tituloCategoria) {
		this.tituloCategoria = tituloCategoria;
	}
	
	public VideoModel converter(CategoriaRepository categoriarepository) {
		CategoriaModel categoria = categoriarepository.findByTitulo(tituloCategoria);
		return new VideoModel(titulo, descricao, url, categoria);
	}



}
