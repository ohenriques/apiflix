package com.opeh.flix.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "TB_CATEGORIA")
public class CategoriaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcategoria;
	@NotEmpty
	private String titulo;
	@NotEmpty
	private String cor;
	@OneToMany
	private List<VideoModel> video;
	
	public Long getId() {
		return idcategoria;
	}
	public void setId(Long id) {
		this.idcategoria = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

	public List<VideoModel> getVideo() {
		return video;
	}

	public void setVideo(List<VideoModel> video) {
		this.video = video;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
