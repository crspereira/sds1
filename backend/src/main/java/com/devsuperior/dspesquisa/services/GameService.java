package com.devsuperior.dspesquisa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.repositories.GameRepository;

//Classe na camada serviços para intermediar os dados entre o Controlador e o Repository
@Service
public class GameService {
	
	//dependêcia com o gameRepository
	@Autowired //injeta automaticamente dependência. //instância automaticamente GameRepository
	private GameRepository repository;
	
	//método que vai retornar a lista de Games
	@Transactional(readOnly = true)
	public List<GameDTO> findAll() {
		//busca os dados do banco de dados e os armazenas em uma lista de game
		List<Game> list = repository.findAll();
		//tranforma a lista de Games e lista de GamesDTO
		return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
		
	}

}
