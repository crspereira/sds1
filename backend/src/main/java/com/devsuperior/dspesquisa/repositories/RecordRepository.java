package com.devsuperior.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dspesquisa.entities.Record;

//herda da Spring.data.JPA várias operaçãoes básicas para acessar o banco de dados (CRUD)
public interface RecordRepository extends JpaRepository<Record, Long>{
	
}
