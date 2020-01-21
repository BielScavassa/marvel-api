package com.gabriel.scavassa.marvelapi.controller;

import com.gabriel.scavassa.marvelapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/public/characters")
public class CharactersController {

    private CharacterService characterService;

    @Autowired
    public CharactersController(CharacterService characterService) {
        this.characterService = characterService;
    }
}
