package com.javawsnosql.mongodbaula.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawsnosql.mongodbaula.domain.Usuario;
import com.javawsnosql.mongodbaula.repositories.UsuarioRepository;
import com.javawsnosql.mongodbaula.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(String id) {
		try {
			Usuario usuario = repository.findById(id).get();
			return usuario;
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}
	
}
