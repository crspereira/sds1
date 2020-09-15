package com.devsuperior.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.devsuperior.dspesquisa.entities.Game;

//herda da Spring.data.JPA várias operaçãoes básicas para acessar o banco de dados (CRUD)
//@Component
@Repository //registra a classe GAMEREPOSITORY com um componente gerenciado pelo SpringBoot
public interface GameRepository extends JpaRepository<Game, Long>{
	
}
