package com.javawsnosql.mongodbaula.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javawsnosql.mongodbaula.domain.Usuario;
import com.javawsnosql.mongodbaula.dto.UsuarioDTO;
import com.javawsnosql.mongodbaula.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<Usuario> listaDeUsuarios = service.findAll();	
		List<UsuarioDTO> listaDeUsuariosDto = listaDeUsuarios.stream().map(user -> new UsuarioDTO(user)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDeUsuariosDto);	
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> findById(@PathVariable String id){
		Usuario usuario = service.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(usuario));	
	}
	
}
