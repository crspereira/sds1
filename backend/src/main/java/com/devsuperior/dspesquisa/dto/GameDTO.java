package com.devsuperior.dspesquisa.dto;

import java.io.Serializable;

import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.entities.enums.Platform;

//classe responsável por trafegar os objetos entre os CONTROLLER(Resources) e as Entidades
//Serializable padrão do JAVA para converter um obejto em bytes. Para se poder gravar em arquivo e trafegar na rede
public class GameDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//objetos que precisam ser trafegados
	private Long id;
	private String title;
	private Platform platform;
	
	/*construtor genérico e recebendo uma identidade para se ter uma forma prática para
	  instânciar o GameDTO apartir de uma Game */
	public GameDTO() {
	}
	
	public GameDTO(Game entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.platform = entity.getPlatform();
	}

	//getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	
	
}
