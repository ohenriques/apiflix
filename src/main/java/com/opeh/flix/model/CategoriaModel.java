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

import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "categoria")
public class CategoriaModel extends RepresentationModel<CategoriaModel> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotEmpty(message = "O campo é obrigatório")
	private String titulo;
	@NotEmpty(message = "O campo é obrigatório")  
	private String cor;
	@OneToMany
	private List<VideoModel> videos;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
