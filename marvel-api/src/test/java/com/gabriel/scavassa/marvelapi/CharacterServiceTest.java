package com.gabriel.scavassa.marvelapi;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.repository.CharacterRepository;
import com.gabriel.scavassa.marvelapi.service.CharacterService;
import com.gabriel.scavassa.marvelapi.util.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CharacterServiceTest {

    @Mock
    CharacterRepository characterRepository;
    @Autowired
    CharacterService characterService;

    @Before
    public void before() {
        FixtureFactoryLoader.loadTemplates("com.gabriel.scavassa.marvelapi.templates");
    }

    @Test
    public void whenCharacterService_SearchCahracters_theReturnCharacters() {
        //GIVEN
        List<Character> characterList = Fixture.from(Character.class).gimme(1, "valid character");
        List<Character> characterCompleteList = Fixture.from(Character.class).gimme(1, "valid complete character");
        Page<Character> characterPage = new PageImpl<>(characterCompleteList);

        //WHEN
        when(characterRepository.findAll()).thenReturn(characterList);
        Page<Character> returnedPageCharacter = characterService.searchCharacters(0, 24, "name", "ASC");

        //THEN
        assertEquals(characterPage.getContent().get(0).getId(), returnedPageCharacter.getContent().get(0).getId());
        assertEquals(characterPage.getContent().get(0).getName(), returnedPageCharacter.getContent().get(0).getName());
        assertEquals(characterPage.getContent().get(0).getDescription(), returnedPageCharacter.getContent().get(0).getDescription());
        assertEquals(characterPage.getContent().get(0).getResourceURI(), returnedPageCharacter.getContent().get(0).getResourceURI());
        assertEquals(characterPage.getContent().get(0).getThumbnail(), returnedPageCharacter.getContent().get(0).getThumbnail());
        assertEquals(characterPage.getContent().get(0).getUrl().length, returnedPageCharacter.getContent().get(0).getUrl().length);
        assertEquals(characterPage.getContent().get(0).getModified(), returnedPageCharacter.getContent().get(0).getModified());

    }

    @Test
    public void whenCharacterService_SearchCahractersById_theReturnCharacter() {
        //GIVEN
        Character character = Fixture.from(Character.class).gimme("valid character");
        Character characterComplete = Fixture.from(Character.class).gimme("valid complete character");

        //WHEN
        when(characterRepository.findById(any())).thenReturn(Optional.of(character));
        Character returnedPageCharacter = characterService.searchCharacterById(1);

        //THEN
        assertEquals(characterComplete.getId(), returnedPageCharacter.getId());
        assertEquals(characterComplete.getName(), returnedPageCharacter.getName());
        assertEquals(characterComplete.getDescription(), returnedPageCharacter.getDescription());
        assertEquals(characterComplete.getResourceURI(), returnedPageCharacter.getResourceURI());
        assertEquals(characterComplete.getThumbnail(), returnedPageCharacter.getThumbnail());
        assertEquals(characterComplete.getUrl().length, returnedPageCharacter.getUrl().length);
        assertEquals(characterComplete.getModified(), returnedPageCharacter.getModified());

    }

    @Test(expected = NotFoundException.class)
    public void whenCharacterService_SearchCahractersById_theReturnNotFoundException() {
        //GIVEN
        Character character = Fixture.from(Character.class).gimme("valid character");

        //WHEN
        when(characterRepository.findById(any())).thenReturn(Optional.of(character));
        Character returnedPageCharacter = characterService.searchCharacterById(33);

    }

}
