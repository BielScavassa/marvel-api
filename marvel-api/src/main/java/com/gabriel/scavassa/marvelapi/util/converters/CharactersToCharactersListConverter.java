package com.gabriel.scavassa.marvelapi.util.converters;

import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.dtos.lists.CharactersList;
import com.gabriel.scavassa.marvelapi.dtos.summaries.CharactersSummary;

import java.util.ArrayList;
import java.util.List;

public class CharactersToCharactersListConverter {

    static public List<CharactersList> charactersToCharacterList(List<Character> characters) {
        List<CharactersList> listOfCharctersList = new ArrayList<>();
        for (Character character : characters) {
            CharactersSummary charactersSummary = new CharactersSummary();
            CharactersList charactersList = new CharactersList();
            charactersList.setAvaliable(characters.size());
            if (characters.size() > 20)
                charactersList.setReturned(20);
            charactersList.setReturned(characters.size());
            charactersList.setCollectionURI("Http://" + character.getName() + "comicCollectionURI");
            charactersSummary.setRessourceURI(character.getResourceURI());
            charactersSummary.setName(character.getName());
            charactersSummary.setRole(character.getDescription());
            charactersList.addCharacterSumary(charactersSummary, characters.size());

            listOfCharctersList.add(charactersList);
        }
        return listOfCharctersList;
    }
}
