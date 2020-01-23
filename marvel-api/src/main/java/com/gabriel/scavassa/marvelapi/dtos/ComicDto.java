package com.gabriel.scavassa.marvelapi.dtos;

import com.gabriel.scavassa.marvelapi.domain.Image;
import com.gabriel.scavassa.marvelapi.domain.Url;
import com.gabriel.scavassa.marvelapi.domain.comic.Comic;
import com.gabriel.scavassa.marvelapi.domain.comic.ComicDate;
import com.gabriel.scavassa.marvelapi.domain.comic.ComicPrice;
import com.gabriel.scavassa.marvelapi.domain.comic.TextObjects;
import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;
import com.gabriel.scavassa.marvelapi.dtos.lists.*;
import com.gabriel.scavassa.marvelapi.util.converters.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class ComicDto {
    private Integer id;
    private int digitalId;
    private String title;
    private double issueNumber;
    private String variantDescription;
    private String description;
    private LocalDate modified;
    private String isbn;
    private String upc;
    private String diamondCode;
    private String ean;
    private String issn;
    private String format;
    private int pageCount;
    private TextObjects[] textObjects = new TextObjects[10];
    private String resourceURI;
    private Url[] url = new Url[10];
    private ComicSumary[] variants = new ComicSumary[10];
    private ComicSumary[] collections = new ComicSumary[10];
    private ComicSumary[] collectedissues = new ComicSumary[10];
    private ComicDate[] dates = new ComicDate[10];
    private ComicPrice[] prices = new ComicPrice[10];
    private Image thumbnail;
    private Image[] images = new Image[10];
    private List<CreatorsList> creators;
    private List<CharactersList> characters;
    private List<StorieList> stories;
    private List<EventList> events;
    private List<SeriesList> series;

    public ComicDto(Comic comic) {
        this.id = comic.getId();
        this.digitalId = comic.getDigitalId();
        this.title = comic.getTitle();
        this.issueNumber = comic.getIssueNumber();
        this.variantDescription = comic.getVariantDescription();
        this.description = comic.getDescription();
        this.modified = comic.getModified();
        this.isbn = comic.getIsbn();
        this.upc = comic.getUpc();
        this.diamondCode = comic.getDiamondCode();
        this.ean = comic.getEan();
        this.issn = comic.getIssn();
        this.format = comic.getFormat();
        this.pageCount = comic.getPageCount();
        this.textObjects = comic.getTextObjects();
        this.resourceURI = comic.getResourceURI();
        this.url = comic.getUrl();
        this.variants = comic.getVariants();
        this.collections = comic.getCollections();
        this.collectedissues = comic.getCollectedissues();
        this.dates = comic.getDates();
        this.prices = comic.getPrices();
        this.thumbnail = comic.getThumbnail();
        this.images = comic.getImages();
        this.creators = CreatorsToCreatorsListConverter.comicsToComicList(comic.getCreators());
        this.characters = CharactersToCharactersListConverter.charactersToCharacterList(comic.getCharacters());
        this.stories = StoriesToStoriesListConverter.storiesToStorieList(comic.getStories());
        this.events = EventsToEventsListConverter.eventToEventList(comic.getEvents());
        this.series = SeriesToSeriesListConverter.seriesToSeriesList(comic.getSeries());
    }


}
