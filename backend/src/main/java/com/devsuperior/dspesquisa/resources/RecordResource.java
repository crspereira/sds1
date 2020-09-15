package com.devsuperior.dspesquisa.resources;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.services.RecordService;


//RESOURCE = Controlador REST responsável por controlar as requisições WEB
//recursos é um conceito e rest é a implementação deste conceito
//esta classe é responsável por controlar todas as operações relacionadas a Entidade Game.
@RestController
@RequestMapping(value = "/records") //endpoint - rota principal do recurso game
public class RecordResource {
	
	/*
	 * //dependência temporária sem camada de serviço //Autowired - mecanismo de
	 * injeção de dependência transparente do SpringBoot
	 * 
	 * @Autowired //anotation reponsável por resolver a dependência e entregar uma
	 * instância automaticamente private GameRepository gameRepository;
	 */
	@Autowired //instância automaticamente GameService
	private RecordService service;
	
	//Método de teste para a rota e request da lista de Games
	//Este é um método weservice REST acessando os dados araves da camada de dados (repostory)
	//ResponseEntity classe do spring que retorna a resposta de uma requisição com algum conteúdo.
	@PostMapping //annotation para avisar sobre a requisição
	public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto) {

		RecordDTO newDTO = service.insert(dto);
		//método OK constroi um objeto se houver uma resposta. método Body inclui a resposta
		return ResponseEntity.ok().body(newDTO);
	}
	
	@GetMapping //annotation para avisar sobre a requisição
	//funcão que recebe 6 parametros
	public ResponseEntity<Page<RecordDTO>> findAll(
			@RequestParam(value = "dateMin", defaultValue = "") String dateMin,
			@RequestParam(value = "dateMax", defaultValue = "") String dateMax,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		
		//tratamento da data
		Instant minDate = ("".equals(dateMin)) ? null : Instant.parse(dateMin);
		Instant maxDate = ("".equals(dateMax)) ? null : Instant.parse(dateMax);
		
		//certifica que todos os registros serão retornados
		if (linesPerPage == 0) {
			linesPerPage = Integer.MAX_VALUE;
		}
		
		//controla a paginação
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<RecordDTO> list = service.findByMoments(minDate, maxDate, pageRequest);
		//método OK constroi um objeto se houver uma resposta. método Body inclui a resposta
		return ResponseEntity.ok().body(list);
	}
 
}
