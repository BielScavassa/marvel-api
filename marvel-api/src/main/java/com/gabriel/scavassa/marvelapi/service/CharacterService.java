package com.gabriel.scavassa.marvelapi.service;

import com.gabriel.scavassa.marvelapi.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

}
