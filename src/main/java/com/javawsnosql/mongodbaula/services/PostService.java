package com.javawsnosql.mongodbaula.services;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawsnosql.mongodbaula.domain.Post;
import com.javawsnosql.mongodbaula.repositories.PostRepository;
import com.javawsnosql.mongodbaula.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		try {
			Post post = repository.findById(id).get();
			return post;
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}
	
	public List<Post> findByTitulo(String texto){
		return repository.findByTituloContainingIgnoreCase(texto);
	}
	
	public List<Post> findByConteudo(String texto){
		return repository.findByConteudo(texto);
	}
	
	public List<Post> buscarEmTudo(String texto, Date minData, Date maxData){
		maxData = new Date(maxData.getTime() + 24 * 60 * 60 * 1000);
		return repository.buscarEmTudo(texto, minData, maxData);
	}
}
