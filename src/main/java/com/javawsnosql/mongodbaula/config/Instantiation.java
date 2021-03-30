package com.javawsnosql.mongodbaula.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.javawsnosql.mongodbaula.domain.Post;
import com.javawsnosql.mongodbaula.domain.Usuario;
import com.javawsnosql.mongodbaula.dto.AutorDTO;
import com.javawsnosql.mongodbaula.dto.ComentarioDTO;
import com.javawsnosql.mongodbaula.repositories.PostRepository;
import com.javawsnosql.mongodbaula.repositories.UsuarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepository.deleteAll();
		postRepository.deleteAll();
		
		Usuario alex = new Usuario(null, "Alex Carvalho", "alex-carvalho@gmail.com");
		Usuario bianca = new Usuario(null, "Bianca Monteiro", "bia_monte@hotmail.com");
		Usuario carla = new Usuario(null, "Carla Lopes Rodrigues", "carla.rog@outlook.com");
		Usuario david = new Usuario(null, "David Santanna", "sant.david@uol.com.br");
		
		usuarioRepository.saveAll(Arrays.asList(alex, bianca, carla, david));
		
		Post post1 = new Post(null, sdf.parse("23/03/2018"), "Partiu viagem!", "Vou viajar para São Paulo. Abraços!", new AutorDTO(bianca));
		Post post2 = new Post(null, sdf.parse("11/09/2019"), "Bom dia", "Chalé e chocolate quente, dia feliz!", new AutorDTO(bianca));
		Post post3 = new Post(null, sdf.parse("09/12/2019"), "Sol", "Hoje vai dar praia. Dia de pescaria ;)", new AutorDTO(alex));
		
		ComentarioDTO comentario1 = new ComentarioDTO(sdf.parse("23/03/2018"), "Boa viagem!", new AutorDTO(alex));
		ComentarioDTO comentario2 = new ComentarioDTO(sdf.parse("11/09/2019"), "Que sonho, te invejo.", new AutorDTO(carla));
		ComentarioDTO comentario3 = new ComentarioDTO(sdf.parse("11/09/2019"), "Excelente!! Tambem quero chocolate.", new AutorDTO(david));
		ComentarioDTO comentario4 = new ComentarioDTO(sdf.parse("09/12/2019"), "Adoro peixe, deu fome.", new AutorDTO(carla));
		ComentarioDTO comentario5 = new ComentarioDTO(sdf.parse("09/12/2019"), "Estou fora, detesto calor.", new AutorDTO(bianca));
		
		post1.getComentarios().addAll(Arrays.asList(comentario1));
		post2.getComentarios().addAll(Arrays.asList(comentario2, comentario3));
		post3.getComentarios().addAll(Arrays.asList(comentario4, comentario5));
		
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		
		bianca.getPosts().addAll(Arrays.asList(post1, post2));
		carla.getPosts().addAll(Arrays.asList(post3));
		
		usuarioRepository.saveAll(Arrays.asList(bianca, carla));
		
		
	}

}
