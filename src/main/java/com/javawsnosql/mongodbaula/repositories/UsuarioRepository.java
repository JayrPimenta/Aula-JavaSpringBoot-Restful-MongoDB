package com.javawsnosql.mongodbaula.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javawsnosql.mongodbaula.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
