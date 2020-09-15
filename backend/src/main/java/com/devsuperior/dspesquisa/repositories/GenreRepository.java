package com.devsuperior.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dspesquisa.entities.Genre;

//herda da Spring.data.JPA várias operaçãoes básicas para acessar o banco de dados (CRUD)
@Repository //registra a classe GENREREPOSITORY com um componente gerenciado pelo SpringBoot
public interface GenreRepository extends JpaRepository<Genre, Long>{
	
}
