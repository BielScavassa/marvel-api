package com.gabriel.scavassa.marvelapi.controller;

import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.domain.Event;
import com.gabriel.scavassa.marvelapi.domain.Series;
import com.gabriel.scavassa.marvelapi.domain.Stories;
import com.gabriel.scavassa.marvelapi.domain.comic.Comic;
import com.gabriel.scavassa.marvelapi.dtos.*;
import com.gabriel.scavassa.marvelapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/public//characters")
public class CharactersController {

    private CharacterService characterService;

    @Autowired
    public CharactersController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<Page<CharacterDto>> getCharacters(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                     @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                     @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                                     @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        Page<Character> characters = characterService.searchCharacters(page, linesPerPage, orderBy, direction);
        Page<CharacterDto> characterDtoPage = characters.map(CharacterDto::new);
        return new ResponseEntity<>(characterDtoPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{characterId}")
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<CharacterDto> getCharactersById(@PathVariable Integer characterId) {

        Character character = characterService.searchCharacterById(characterId);
        CharacterDto characterDto = new CharacterDto(character);
        return new ResponseEntity<>(characterDto, HttpStatus.OK);
    }

    @GetMapping("/{characterId}/comics")
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<List<ComicDto>> getComicsByCharactersId(@PathVariable Integer characterId) {
        List<ComicDto> comicDtoList = new ArrayList<>();
        Character character = characterService.searchCharacterById(characterId);
        List<Comic> comicList = character.getComics();
        for (Comic comic : comicList) {
            ComicDto comicDto = new ComicDto(comic);
            comicDtoList.add(comicDto);
        }
        return new ResponseEntity<>(comicDtoList, HttpStatus.OK);
    }

    @GetMapping("/{characterId}/events")
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<List<EventDto>> getEventssByEventsId(@PathVariable Integer characterId) {
        List<EventDto> eventDtoList = new ArrayList<>();
        Character character = characterService.searchCharacterById(characterId);
        List<Event> eventList = character.getEvents();
        for (Event event : eventList) {
            EventDto eventDto = new EventDto(event);
            eventDtoList.add(eventDto);
        }
        return new ResponseEntity<>(eventDtoList, HttpStatus.OK);
    }

    @GetMapping("/{characterId}/series")
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<List<SeriesDto>> getSeriesBySeriesId(@PathVariable Integer characterId) {
        List<SeriesDto> seriesDtoList = new ArrayList<>();
        Character character = characterService.searchCharacterById(characterId);
        List<Series> seriesList = character.getSeries();
        for (Series series : seriesList) {
            SeriesDto seriesDto = new SeriesDto(series);
            seriesDtoList.add(seriesDto);
        }
        return new ResponseEntity<>(seriesDtoList, HttpStatus.OK);
    }

    @GetMapping("/{characterId}/stories")
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<List<StoriesDto>> getStoriesByStoriesId(@PathVariable Integer characterId) {
        List<StoriesDto> storiesDtos = new ArrayList<>();
        Character character = characterService.searchCharacterById(characterId);
        List<Stories> storiesList = character.getStories();
        for (Stories series : storiesList) {
            StoriesDto seriesDto = new StoriesDto(series);
            storiesDtos.add(seriesDto);
        }
        return new ResponseEntity<>(storiesDtos, HttpStatus.OK);
    }

}
