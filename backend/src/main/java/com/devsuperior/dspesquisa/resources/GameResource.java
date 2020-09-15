package com.devsuperior.dspesquisa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.services.GameService;


//RESOURCE = Controlador REST responsável por controlar as requisições WEB
//recursos é um conceito e rest é a implementação deste conceito
//esta classe é responsável por controlar todas as operações relacionadas a Entidade Game.
@RestController
@RequestMapping(value = "/games") //endpoint - rota principal do recurso game
public class GameResource {
	
	/*
	 * //dependência temporária sem camada de serviço //Autowired - mecanismo de
	 * injeção de dependência transparente do SpringBoot
	 * 
	 * @Autowired //anotation reponsável por resolver a dependência e entregar uma
	 * instância automaticamente private GameRepository gameRepository;
	 */
	@Autowired //instância automaticamente GameService
	private GameService service;
	
	//Método de teste para a rota e request da lista de Games
	//Este é um método weservice REST acessando os dados araves da camada de dados (repostory)
	//ResponseEntity classe do spring que retorna a resposta de uma requisição com algum conteúdo.
	@GetMapping //annotation para avisar sobre a requisição
	public ResponseEntity<List<GameDTO>> findAll() {
		List<GameDTO> list = service.findAll();
		//método OK constroi um objeto se houver uma resposta. método Body inclui a resposta
		return ResponseEntity.ok().body(list);
	}

}
