package com.javawsnosql.mongodbaula.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.javawsnosql.mongodbaula.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ $and: [ {date: { $gte: ?1 } }, "
			+ "{ date: { $lte: ?2 } }, "
			+ "{ $or: [ "
				+ "{ 'titulo': { $regex: ?0, $options: 'i' } }, "
				+ "{ 'conteudo': { $regex: ?0, $options: 'i' } }, "
				+ "{ 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> buscarEmTudo(String texto, Date minData, Date maxData); // Consulta avançada com o @Query
	
	@Query("{'conteudo': { $regex: ?0, $options: 'i'} }")
	List<Post> findByConteudo(String texto); // Consulta simples com o @Query
	
	List<Post> findByTituloContainingIgnoreCase(String texto); // Consulta simples Query Methods
	
}
