package com.gabriel.scavassa.marvelapi;

import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.domain.*;
import com.gabriel.scavassa.marvelapi.domain.comic.Comic;
import com.gabriel.scavassa.marvelapi.domain.comic.ComicDate;
import com.gabriel.scavassa.marvelapi.domain.comic.ComicPrice;
import com.gabriel.scavassa.marvelapi.domain.comic.TextObjects;
import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;
import com.gabriel.scavassa.marvelapi.domain.summaries.EventSumary;
import com.gabriel.scavassa.marvelapi.repository.*;
import com.gabriel.scavassa.marvelapi.repository.comic.ComicDateRepository;
import com.gabriel.scavassa.marvelapi.repository.comic.ComicPriceRepository;
import com.gabriel.scavassa.marvelapi.repository.comic.ComicRepository;
import com.gabriel.scavassa.marvelapi.repository.comic.TextObjectsRepository;
import com.gabriel.scavassa.marvelapi.repository.summaries.ComicSumaryRepository;
import com.gabriel.scavassa.marvelapi.repository.summaries.EventSumaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableWebMvc
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
    private ImageRepository imageRepository;
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
    @Autowired
    private EventSumaryRepository eventSumaryRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private CreatorsRepository creatorsRepository;


    @Override
    public void run(String... args) throws Exception {

        Url[] urlArray = new Url[10];
        Url url = new Url(null, "Urls", "Https://hulkurls");
        urlArray[0] = url;

        Image[] images = new Image[10];
        Image thumbnail = new Image(null, "Https://imageurl", "C://hulk/images");
        images[0] = thumbnail;


        ComicSumary variantsArray[] = new ComicSumary[10];
        ComicSumary variants = new ComicSumary(null, "Https://ressourceVariantsUri", "Canonic variant");
        variantsArray[0] = variants;

        ComicSumary collectionsArray[] = new ComicSumary[10];
        ComicSumary collections = new ComicSumary(null, "Https://ressourceCollectionsUri", "Canonic collections");
        collectionsArray[0] = collections;

        ComicSumary colectedissuesArray[] = new ComicSumary[10];
        ComicSumary colectedissues = new ComicSumary(null, "Https://ressourceColectedissuesUri", "Canonic colectedissues");
        colectedissuesArray[0] = colectedissues;

        ComicSumary originalissue = new ComicSumary(null, "Https://ressourceOriginalissueUri", "Canonic original issue");

        TextObjects textHulkComicArray[] = new TextObjects[1];
        TextObjects textHulkComic = new TextObjects(null, "Text", "Pt-Br", "Smash Smash and Smash");
        textHulkComicArray[0] = textHulkComic;

        ComicDate comicDateArray[] = new ComicDate[10];
        ComicDate comicDate = new ComicDate(null, "On sale date", LocalDate.now());
        comicDateArray[0] = comicDate;

        ComicPrice comicPriceArray[] = new ComicPrice[10];
        ComicPrice comicPrice = new ComicPrice(null, "Digital Price", 35.00f);

        EventSumary next = new EventSumary(null, "Https://ressourcenextEventUri", "Hulk event 2.0");
        EventSumary previous = new EventSumary(null, "Https://ressourcePreviouseEventUri", "Hulk event with avangers");

        List<Creators> hulkCreatorsList = new ArrayList<>();
        Creators hulkCreators = new Creators(null, "First Name", "Middle Name", "Last Name", "Suffix", "Hulk Creator", LocalDate.now(), "Https://hulkCreator", null, thumbnail, null, null, null, null);
        hulkCreatorsList.add(hulkCreators);

        List<Series> hulkSeeriesList = new ArrayList<>();
        Series hulkSeries = new Series(null, "Hulk Series", "Series for hulk", "Https://hulkSeries", urlArray, 2002, 2005, "14", LocalDate.now(), thumbnail, null, null, null, null, hulkCreatorsList, next, previous);
        hulkSeeriesList.add(hulkSeries);

        List<Event> hulkEventList = new ArrayList<>();
        Event hulkEvent = new Event(null, "Hulk Event", "Event for hulk", "Https://hulkevent", urlArray, LocalDate.now(), LocalDate.now(), LocalDate.now(), thumbnail, null, null, hulkSeeriesList, null, hulkCreatorsList, next, previous);
        hulkEventList.add(hulkEvent);

        List<Stories> hulkStoriesList = new ArrayList<>();
        Stories hulkStories = new Stories(null, "Hulk Storie", "A storie of hulk", "Https://hulkstorie", "Interior story", LocalDate.now(), thumbnail, null, hulkSeeriesList, hulkEventList, null, hulkCreatorsList, originalissue);
        hulkStoriesList.add(hulkStories);

        List<Comic> hulkComicList = new ArrayList<>();
        Comic hulkComic = new Comic(null, 1, "HulkSmash", 22.2, "Variant of Hulk", "Hulk Comic Smash!", LocalDate.now(), "isbn", "upc", "diamondCode", "ean", "issn", "comic", 2, textHulkComicArray, "Https://HulkComicUrl", urlArray
                , variantsArray, collectionsArray, colectedissuesArray, comicDateArray, comicPriceArray, thumbnail, images, hulkCreatorsList, null, hulkStoriesList, hulkEventList, hulkSeeriesList);
        hulkComicList.add(hulkComic);

        Character hulk = new Character(null, "Hulk", "Green", LocalDate.now(), "Https://Hulk", urlArray, thumbnail, hulkComicList, hulkStoriesList, hulkEventList, hulkSeeriesList);

        comicPriceRepository.save(comicPrice);
        comicSumaryRepository.saveAll(Arrays.asList(variants, collections, colectedissues, originalissue));
        urlRepository.save(url);
        imageRepository.save(thumbnail);
        comicDateRepository.save(comicDate);
        textObjectsRepository.save(textHulkComic);
        eventSumaryRepository.saveAll(Arrays.asList(previous, next));
        creatorsRepository.save(hulkCreators);
        seriesRepository.save(hulkSeries);
        eventRepository.save(hulkEvent);
        storiesRepository.save(hulkStories);
        comicRepository.save(hulkComic);
        characterRepository.save(hulk);


    }

}
