package com.devsuperior.dspesquisa.dto;

import java.io.Serializable;

import com.devsuperior.dspesquisa.entities.Record;

//classe responsável por trafegar os objetos entre os CONTROLLER(Resources) e as Entidades
//Serializable padrão do JAVA para converter um obejto em bytes. Para se poder gravar em arquivo e trafegar na rede
public class RecordInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	//objetos que precisam ser trafegados
	private String name;
	private Integer age;
	private Long gameId;
	
	/*construtor genérico e recebendo uma identidade para se ter uma forma prática para
	  instânciar o GameDTO apartir de uma Game */
	public RecordInsertDTO() {
	}
	
	public RecordInsertDTO(Record entity) {
		this.name = entity.getName();
		this.age = entity.getAge();
		this.gameId = entity.getId();	
	}
	
	//getters e setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	
	
}
