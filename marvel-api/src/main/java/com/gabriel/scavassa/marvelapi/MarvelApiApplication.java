package com.gabriel.scavassa.marvelapi;

import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.domain.Comic;
import com.gabriel.scavassa.marvelapi.domain.ComicDate;
import com.gabriel.scavassa.marvelapi.domain.TextObjects;
import com.gabriel.scavassa.marvelapi.repository.CharacterRepository;
import com.gabriel.scavassa.marvelapi.repository.ComicDateRepository;
import com.gabriel.scavassa.marvelapi.repository.ComicRepository;
import com.gabriel.scavassa.marvelapi.repository.TextObjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableSpringDataWebSupport
public class MarvelApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MarvelApiApplication.class, args);
    }

    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private ComicRepository comicRepository;
    @Autowired
    private TextObjectsRepository textObjectsRepository;
    @Autowired
    private ComicDateRepository comicDateRepository;


    @Override
    public void run(String... args) throws Exception {

        TextObjects textHulkComicArray[] = new TextObjects[1];
		ComicDate comicDateArray[] = new ComicDate[10];
        List<Comic> hulkComicList = new ArrayList<>();

        TextObjects textHulkComic = new TextObjects(null, "Text", "Pt-Br", "Smash Smash and Smash");
        textHulkComicArray[0] = textHulkComic;
        ComicDate comicDate = new ComicDate(null, "On sale date", LocalDate.now());
        comicDateArray[0] = comicDate;

        Comic hulkComic = new Comic(null, 1, "Hulk Comic", 22.2, "Variant of Hulk", "Hulk Comic Smash!", LocalDate.now(), "isbn", "upc", "diamondCode", "ean", "issn", "format", 2, textHulkComicArray, "Https://HulkComicUrl", comicDateArray, null);
        hulkComicList.add(hulkComic);

        Character hulk = new Character(null, "Hulk", "Green", LocalDate.now(), "Https://Hulk", hulkComicList);

        comicDateRepository.save(comicDate);
		textObjectsRepository.save(textHulkComic);
        comicRepository.save(hulkComic);
        characterRepository.save(hulk);


    }

}
