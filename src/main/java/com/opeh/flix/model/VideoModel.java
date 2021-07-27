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
@Table(name = "TB_VIDEO")
public class VideoModel extends RepresentationModel<VideoModel>  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVideo;
	@NotEmpty
	@Size(min = 3, max = 35, message = "O campo Titulo deve ter entre" + " 3 e 35 caracteres.")
	private String titulo;
	@NotEmpty
	@Size(min = 3, max = 120, message = "O campo Descrição deve ter entre" + " 3 e 120 caracteres.")
	private String descricao;
	@NotEmpty
	@Size(max = 35, message = "A URL é longa de mais.")
	private String url;
	@ManyToOne
	private CategoriaModel teste1;

	public Long getId() {
		return idVideo;
	}

	public void setId(Long id) {
		this.idVideo = id;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public CategoriaModel getCategoriaIdIdCategoria() {
		return teste1;
	}

	public void setCategoriaId(CategoriaModel categoriaId) {
		this.teste1 = categoriaId;
	}

}
