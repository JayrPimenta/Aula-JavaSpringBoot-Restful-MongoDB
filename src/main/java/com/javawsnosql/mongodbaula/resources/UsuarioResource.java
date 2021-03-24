package com.javawsnosql.mongodbaula.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javawsnosql.mongodbaula.domain.Usuario;
import com.javawsnosql.mongodbaula.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> listaDeUsuarios = service.findAll();	
		return ResponseEntity.ok().body(listaDeUsuarios);	
	}
	
}