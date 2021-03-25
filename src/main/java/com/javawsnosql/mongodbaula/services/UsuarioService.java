package com.javawsnosql.mongodbaula.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawsnosql.mongodbaula.domain.Usuario;
import com.javawsnosql.mongodbaula.dto.UsuarioDTO;
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
	
	public Usuario insert(Usuario usuario) {
		return repository.insert(usuario);
	}
	
	public void delete(String id) {
		findById(id); // Verifica o id informado tem correspondencia no DB (Reuso da exceção)
		repository.deleteById(id);
	}
	
	public Usuario update(Usuario usuario) {
		Usuario usuarioAtualizado = findById(usuario.getId());
		updateData(usuarioAtualizado, usuario);
		return repository.save(usuarioAtualizado);
		
	}
	
	private void updateData(Usuario usuarioAtualizado, Usuario usuario) {
		usuarioAtualizado.setNome(usuario.getNome());
		usuarioAtualizado.setEmail(usuario.getEmail());	
	}

	public Usuario fromDTO(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(), usuarioDTO.getEmail());
	}
	
	
	
	
}
