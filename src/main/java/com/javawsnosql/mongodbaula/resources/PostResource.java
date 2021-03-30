package com.javawsnosql.mongodbaula.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javawsnosql.mongodbaula.domain.Post;
import com.javawsnosql.mongodbaula.resources.util.URL;
import com.javawsnosql.mongodbaula.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);	
	}
	
	@RequestMapping(value="/buscartitulo", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value="texto") String texto){
		texto = URL.urlDecoder(texto);
		List<Post> listaDePosts = service.findByTitulo(texto);
		return ResponseEntity.ok().body(listaDePosts);	
	}
	
	@RequestMapping(value="/buscarconteudo", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByConteudo(@RequestParam(value="texto") String texto){
		texto = URL.urlDecoder(texto);
		List<Post> listaDePosts = service.findByConteudo(texto);
		return ResponseEntity.ok().body(listaDePosts);	
	}
}
