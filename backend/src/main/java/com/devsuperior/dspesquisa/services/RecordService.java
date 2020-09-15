package com.devsuperior.dspesquisa.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.entities.Record;
import com.devsuperior.dspesquisa.repositories.GameRepository;
import com.devsuperior.dspesquisa.repositories.RecordRepository;

//Classe na camada serviços para intermediar os dados entre o Controlador e o Repository
@Service
public class RecordService {
	
	//dependêcia com o RecordRepository
	@Autowired //injeta automaticamente dependência. //instância automaticamente RecordRepository
	private RecordRepository repository;
	
	//dependêcia com o gameRepository
	@Autowired //injeta automaticamente dependência. //instância automaticamente GameRepository
	private GameRepository gameRepository;
	
	//método que insere o um RecordInsertDTO e retorna um RecordDTO completo
	@Transactional(readOnly = true)
	public RecordDTO insert(RecordInsertDTO dto) {
		
		Record entity = new Record();
		
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());
		
		//getOne é do spring.data.jpa que instacia o objeto não grava no banco
		Game game = gameRepository.getOne(dto.getGameId()); 
		entity.setGame(game);
		
		entity = repository.save(entity);
		
		return new RecordDTO(entity);
		
	}
	
	

}
