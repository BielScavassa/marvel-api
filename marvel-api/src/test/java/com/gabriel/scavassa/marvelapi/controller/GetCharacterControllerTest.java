package com.gabriel.scavassa.marvelapi.controller;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.repository.*;
import com.gabriel.scavassa.marvelapi.repository.comic.ComicDateRepository;
import com.gabriel.scavassa.marvelapi.repository.comic.ComicPriceRepository;
import com.gabriel.scavassa.marvelapi.repository.comic.ComicRepository;
import com.gabriel.scavassa.marvelapi.repository.comic.TextObjectsRepository;
import com.gabriel.scavassa.marvelapi.repository.summaries.ComicSumaryRepository;
import com.gabriel.scavassa.marvelapi.repository.summaries.EventSumaryRepository;
import com.gabriel.scavassa.marvelapi.service.CharacterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GetCharacterControllerTest.class)
public class GetCharacterControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    CharacterService characterService;
    @MockBean
    private CharacterRepository characterRepository;
    @MockBean
    private ComicRepository comicRepository;
    @MockBean
    private UrlRepository urlRepository;
    @MockBean
    private ImageRepository imageRepository;
    @MockBean
    private ComicSumaryRepository comicSumaryRepository;
    @MockBean
    private TextObjectsRepository textObjectsRepository;
    @MockBean
    private ComicDateRepository comicDateRepository;
    @MockBean
    private ComicPriceRepository comicPriceRepository;
    @MockBean
    private StoriesRepository storiesRepository;
    @MockBean
    private EventSumaryRepository eventSumaryRepository;
    @MockBean
    private EventRepository eventRepository;
    @MockBean
    private SeriesRepository seriesRepository;
    @MockBean
    private CreatorsRepository creatorsRepository;

    @Before
    public void setup() {
        FixtureFactoryLoader.loadTemplates("com.gabriel.scavassa.marvelapi.templates");
    }

//    @Test
//    public void whenCharacterController_GetCharacters_theReturnStatus200() {
//        //GIVEN
//        List<Character> characterList = Fixture.from(Character.class).gimme(1, "valid character");
//        Page<Character> characterPage = new PageImpl<>(characterList);
//        //WHEN
//        when(characterService.searchCharacters(0, 24, "name", "ASC")).thenReturn(characterPage);
//
//        //THEN
//        try {
//            mockMvc.perform(
//                    get("/v1/public/characters")
//            ).andExpect(status().isOk());
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//    }
//
//    @Test
//    public void whenCharacterController_GetCharacterById_theReturnStatus200() {
//        //GIVEN
//        Character character = Fixture.from(Character.class).gimme("valid character");
//
//        //WHEN
//        when(characterService.searchCharacterById(1)).thenReturn(character);
//
//        //THEN
//        try {
//            mockMvc.perform(
//                    get("/v1/public/characters/1")
//            ).andExpect(status().isOk());
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//    }

    @Test
    public void whenCharacterController_GetCharacterById_theReturnStatus404() {
        //GIVEN
        Character character = Fixture.from(Character.class).gimme("valid character");

        //WHEN
        when(characterService.searchCharacterById(33)).thenReturn(character);

        //THEN
        try {
            mockMvc.perform(
                    get("/v1/public/characters/1")
            ).andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
