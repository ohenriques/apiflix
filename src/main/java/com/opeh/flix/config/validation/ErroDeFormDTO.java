package com.opeh.flix.config.validation;

public class ErroDeFormDTO {

	private String campo;
	private String mensagem;

	public ErroDeFormDTO(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}


	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return mensagem;
	}

}
