package com.gabriel.scavassa.marvelapi;

import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.domain.*;
import com.gabriel.scavassa.marvelapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
    private UrlRepository urlRepository;
    @Autowired
    private ComicSumaryRepository comicSumaryRepository;
    @Autowired
    private TextObjectsRepository textObjectsRepository;
    @Autowired
    private ComicDateRepository comicDateRepository;
    @Autowired
    private ComicPriceRepository comicPriceRepository;
    @Autowired
    private StoriesRepository storiesRepository;


    @Override
    public void run(String... args) throws Exception {

        Url urlArray[] = new Url[10];
        ComicSumary variantsArray[] = new ComicSumary[10];
        ComicSumary collectionsArray[] = new ComicSumary[10];
        ComicSumary colectedissuesArray[] = new ComicSumary[10];
        TextObjects textHulkComicArray[] = new TextObjects[1];
        ComicDate comicDateArray[] = new ComicDate[10];
        ComicPrice comicPriceArray[] = new ComicPrice[10];
        List<Comic> hulkComicList = new ArrayList<>();
        List<Stories> hulkStoriesList = new ArrayList<>();

        Url url = new Url(null, "Urls", "Https://hulkurls ");
        urlArray[0] = url;

        ComicSumary variants = new ComicSumary(null, "Https://ressourceVariantsUrl", "Canonic variant");
        variantsArray[0] = variants;

        ComicSumary collections = new ComicSumary(null, "Https://ressourceCollectionsUrl", "Canonic collections");
        collectionsArray[0] = collections;

        ComicSumary colectedissues = new ComicSumary(null, "Https://ressourceColectedissuesUrl", "Canonic colectedissues");
        colectedissuesArray[0] = colectedissues;

        ComicSumary originalissue = new ComicSumary(null, "Https://ressourceOriginalissueUrl", "Canonic original issue");

        TextObjects textHulkComic = new TextObjects(null, "Text", "Pt-Br", "Smash Smash and Smash");
        textHulkComicArray[0] = textHulkComic;

        ComicDate comicDate = new ComicDate(null, "On sale date", LocalDate.now());
        comicDateArray[0] = comicDate;

        ComicPrice comicPrice = new ComicPrice(null, "Digital Price", 35.00f);

        Stories hulkStories = new Stories(null, "Hulk Storie", "A storie of hulk", "Https://hulkstorie", "Interior story", LocalDate.now(), null, null, originalissue);
        hulkStoriesList.add(hulkStories);

        Comic hulkComic = new Comic(null, 1, "Hulk Comic", 22.2, "Variant of Hulk", "Hulk Comic Smash!", LocalDate.now(), "isbn", "upc", "diamondCode", "ean", "issn", "comic", 2, textHulkComicArray, "Https://HulkComicUrl", urlArray
                , variantsArray, collectionsArray, colectedissuesArray, comicDateArray, comicPriceArray, null, hulkStoriesList);
        hulkComicList.add(hulkComic);

        Character hulk = new Character(null, "Hulk", "Green", LocalDate.now(), "Https://Hulk", hulkComicList, hulkStoriesList);

        comicPriceRepository.save(comicPrice);
        comicSumaryRepository.saveAll(Arrays.asList(variants, collections, colectedissues, originalissue));
        urlRepository.save(url);
        comicDateRepository.save(comicDate);
        textObjectsRepository.save(textHulkComic);
        storiesRepository.save(hulkStories);
        comicRepository.save(hulkComic);
        characterRepository.save(hulk);


    }

}
