package com.javawsnosql.mongodbaula.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.javawsnosql.mongodbaula.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{'conteudo': { $regex: ?0, $options: 'i'} }")
	List<Post> findByConteudo(String texto); // Consulta simples com o @Query
	
	List<Post> findByTituloContainingIgnoreCase(String texto); // Consulta simples Query Methods
}
