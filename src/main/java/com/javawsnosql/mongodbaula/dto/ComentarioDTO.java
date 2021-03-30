package com.javawsnosql.mongodbaula.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Date data;
	private String texto;
	private AutorDTO autor;
	
	public ComentarioDTO() {
	}

	public ComentarioDTO(Date data, String texto, AutorDTO autor) {
		this.data = data;
		this.texto = texto;
		this.autor = autor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}
	
	
	
}
