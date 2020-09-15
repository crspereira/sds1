package com.devsuperior.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dspesquisa.entities.Game;

//herda da Spring.data.JPA várias operaçãoes básicas para acessar o banco de dados (CRUD)
public interface GameRepository extends JpaRepository<Game, Long>{
	
}
