package com.opeh.flix.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "TB_VIDEO")
public class Video {

	private static final long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotEmpty
	@Size(min = 3, max = 35, message = "O campo Titulo deve ter entre" + " 3 e 35 caracteres.")
	private String titulo;
	@NotEmpty
	@Size(min = 3, max = 120, message = "O campo Descrição deve ter entre" + " 3 e 120 caracteres.")
	private String descricao;
	@NotEmpty
	@Size(max = 35, message = "A URL é longa de mais.")
	private String url;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
	}

}
