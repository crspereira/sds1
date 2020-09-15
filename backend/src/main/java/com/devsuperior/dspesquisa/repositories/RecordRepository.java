package com.devsuperior.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dspesquisa.entities.Record;

//herda da Spring.data.JPA várias operaçãoes básicas para acessar o banco de dados (CRUD)
@Repository //registra a classe RECORDREPOSITORY com um componente gerenciado pelo SpringBoot
public interface RecordRepository extends JpaRepository<Record, Long>{
	
}
