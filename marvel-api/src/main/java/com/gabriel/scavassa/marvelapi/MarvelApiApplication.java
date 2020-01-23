package com.gabriel.scavassa.marvelapi;

import com.gabriel.scavassa.marvelapi.repository.*;
import com.gabriel.scavassa.marvelapi.repository.comic.ComicDateRepository;
import com.gabriel.scavassa.marvelapi.repository.comic.ComicPriceRepository;
import com.gabriel.scavassa.marvelapi.repository.comic.ComicRepository;
import com.gabriel.scavassa.marvelapi.repository.comic.TextObjectsRepository;
import com.gabriel.scavassa.marvelapi.repository.summaries.ComicSumaryRepository;
import com.gabriel.scavassa.marvelapi.repository.summaries.EventSumaryRepository;
import com.gabriel.scavassa.marvelapi.util.AddContentToDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

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

        AddContentToDatabase.addContent(characterRepository, comicRepository, urlRepository, imageRepository, comicSumaryRepository,
                textObjectsRepository, comicDateRepository, comicPriceRepository, storiesRepository, eventSumaryRepository, eventRepository, seriesRepository, creatorsRepository);

    }

}
