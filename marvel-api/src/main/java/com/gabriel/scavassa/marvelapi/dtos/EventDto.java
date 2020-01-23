package com.gabriel.scavassa.marvelapi.dtos;

import com.gabriel.scavassa.marvelapi.domain.Event;
import com.gabriel.scavassa.marvelapi.domain.Image;
import com.gabriel.scavassa.marvelapi.domain.Url;
import com.gabriel.scavassa.marvelapi.domain.summaries.EventSumary;
import com.gabriel.scavassa.marvelapi.dtos.lists.*;
import com.gabriel.scavassa.marvelapi.util.converters.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EventDto {
    private Integer id;
    private String title;
    private String description;
    private String resourceUrl;
    private Url[] url = new Url[10];
    private LocalDate modified;
    private LocalDate start;
    private LocalDate end;
    private Image thumbnail;
    private List<ComicList> comics;
    private List<StorieList> stories;
    private List<SeriesList> series;
    private List<CharactersList> characters;
    private List<CreatorsList> creators;
    private EventSumary next;
    private EventSumary previous;

    public EventDto(Event event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.resourceUrl = event.getResourceUrl();
        this.url = event.getUrl();
        this.modified = event.getModified();
        this.start = event.getStart();
        this.end = event.getEnd();
        this.thumbnail = event.getThumbnail();
        this.comics = ComicsToComicsListConverter.comicsToComicList(event.getComics());
        this.stories = StoriesToStoriesListConverter.storiesToStorieList(event.getStories());
        this.series = SeriesToSeriesListConverter.seriesToSeriesList(event.getSeries());
        this.characters = CharactersToCharactersListConverter.charactersToCharacterList(event.getCharacters());
        this.creators = CreatorsToCreatorsListConverter.comicsToComicList(event.getCreators());
        this.next = event.getNext();
        this.previous = event.getPrevious();
    }
}
