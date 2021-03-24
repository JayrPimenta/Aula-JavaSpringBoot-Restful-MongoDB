package com.javawsnosql.mongodbaula.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.javawsnosql.mongodbaula.domain.Usuario;
import com.javawsnosql.mongodbaula.repositories.UsuarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		usuarioRepository.deleteAll();
		
		Usuario alex = new Usuario(null, "Alex Carvalho", "alex-carvalho@gmail.com");
		Usuario bianca = new Usuario(null, "Bianca Monteiro", "bia_monte@hotmail.com");
		Usuario carla = new Usuario(null, "Carla Lopes Rodrigues", "carla.rog@outlook.com");
		Usuario david = new Usuario(null, "David Santanna", "sant.david@uol.com.br");
		
		usuarioRepository.saveAll(Arrays.asList(alex, bianca, carla, david));
	}

}
