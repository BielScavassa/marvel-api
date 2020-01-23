package com.gabriel.scavassa.marvelapi.service;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.repository.CharacterRepository;
import com.gabriel.scavassa.marvelapi.service.CharacterService;
import com.gabriel.scavassa.marvelapi.util.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class CharacterServiceTest {

    @Mock
    CharacterRepository characterRepository;
    @InjectMocks
    CharacterService characterService;

    @Before
    public void setup() {
        FixtureFactoryLoader.loadTemplates("com.gabriel.scavassa.marvelapi.templates");
    }

    @Test
    public void whenCharacterService_SearchCahracters_theReturnCharacters() {
        //GIVEN
        List<Character> characterList = Fixture.from(Character.class).gimme(1, "valid character");
        PageRequest pageRequest = PageRequest.of(0, 24, Sort.Direction.valueOf("ASC"), "name");
        Page<Character> characterPage = new PageImpl<>(characterList);

        //WHEN
        when(characterRepository.findAll(pageRequest)).thenReturn(characterPage);
        Page<Character> returnedPageCharacter = characterService.searchCharacters(0, 24, "name", "ASC");

        //THEN
        assertEquals(characterPage.getContent().get(0).getId(), returnedPageCharacter.getContent().get(0).getId());
        assertEquals(characterPage.getContent().get(0).getName(), returnedPageCharacter.getContent().get(0).getName());
        assertEquals(characterPage.getContent().get(0).getDescription(), returnedPageCharacter.getContent().get(0).getDescription());
        assertEquals(characterPage.getContent().get(0).getResourceURI(), returnedPageCharacter.getContent().get(0).getResourceURI());
        assertEquals(characterPage.getContent().get(0).getThumbnail(), returnedPageCharacter.getContent().get(0).getThumbnail());
        assertEquals(characterPage.getContent().get(0).getUrl().length, returnedPageCharacter.getContent().get(0).getUrl().length);
        assertEquals(characterPage.getContent().get(0).getModified(), returnedPageCharacter.getContent().get(0).getModified());
        assertEquals(characterPage.getContent().get(0).getComics().get(0).getTitle(), returnedPageCharacter.getContent().get(0).getComics().get(0).getTitle());
        assertEquals(characterPage.getContent().get(0).getStories().get(0).getTitle(), returnedPageCharacter.getContent().get(0).getStories().get(0).getTitle());
        assertEquals(characterPage.getContent().get(0).getSeries().get(0).getTitle(), returnedPageCharacter.getContent().get(0).getSeries().get(0).getTitle());
        assertEquals(characterPage.getContent().get(0).getEvents().get(0).getTitle(), returnedPageCharacter.getContent().get(0).getEvents().get(0).getTitle());

    }

    @Test
    public void whenCharacterService_SearchCahractersById_theReturnCharacter() {
        //GIVEN
        Character character = Fixture.from(Character.class).gimme("valid character");

        //WHEN
        when(characterRepository.findById(any())).thenReturn(Optional.of(character));
        Character returnedCharacter = characterService.searchCharacterById(1);

        //THEN
        assertEquals(character.getId(), returnedCharacter.getId());
        assertEquals(character.getName(), returnedCharacter.getName());
        assertEquals(character.getDescription(), returnedCharacter.getDescription());
        assertEquals(character.getResourceURI(), returnedCharacter.getResourceURI());
        assertEquals(character.getThumbnail(), returnedCharacter.getThumbnail());
        assertEquals(character.getUrl().length, returnedCharacter.getUrl().length);
        assertEquals(character.getModified(), returnedCharacter.getModified());
        assertEquals(character.getComics().get(0).getTitle(), returnedCharacter.getComics().get(0).getTitle());
        assertEquals(character.getStories().get(0).getTitle(), returnedCharacter.getStories().get(0).getTitle());
        assertEquals(character.getSeries().get(0).getTitle(), returnedCharacter.getSeries().get(0).getTitle());
        assertEquals(character.getEvents().get(0).getTitle(), returnedCharacter.getEvents().get(0).getTitle());

    }

    @Test(expected = NotFoundException.class)
    public void whenCharacterService_SearchCahractersById_theReturnNotFoundException() {
        //GIVEN
        Character character = Fixture.from(Character.class).gimme("valid character");

        //WHEN
        Character returnedPageCharacter = characterService.searchCharacterById(33);

    }

}
