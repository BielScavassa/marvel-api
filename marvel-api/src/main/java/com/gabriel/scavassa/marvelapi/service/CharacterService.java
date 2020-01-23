package com.gabriel.scavassa.marvelapi.service;

import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.repository.CharacterRepository;
import com.gabriel.scavassa.marvelapi.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public Page<Character> searchCharacters(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return characterRepository.findAll(pageRequest);
    }

    public Character searchCharacterById(Integer characterId) {
        Optional<Character> optionalCharacter = characterRepository.findById(characterId);
        if(!optionalCharacter.isPresent())
            throw new NotFoundException("Character");
        return optionalCharacter.get();
    }

}
