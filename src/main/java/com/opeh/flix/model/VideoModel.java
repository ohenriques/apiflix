package com.opeh.flix.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "video")
public class VideoModel extends RepresentationModel<VideoModel> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	@Size(min = 3, max = 35, message = "O campo Titulo deve ter entre" + " 3 e 35 caracteres.")
	private String titulo;
	@NotEmpty
	@Size(min = 3, max = 120, message = "O campo Descrição deve ter entre" + " 3 e 120 caracteres.")
	private String descricao;
	@NotEmpty
	private String url;
	@ManyToOne
	private CategoriaModel categoria;
	
	public VideoModel() {
	}
	
	

	public VideoModel(
			@NotEmpty @Size(min = 3, max = 35, message = "O campo Titulo deve ter entre 3 e 35 caracteres.") String titulo,
			@NotEmpty @Size(min = 3, max = 120, message = "O campo Descrição deve ter entre 3 e 120 caracteres.") String descricao,
			@NotEmpty String url, CategoriaModel categoria) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
		this.categoria = categoria;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
