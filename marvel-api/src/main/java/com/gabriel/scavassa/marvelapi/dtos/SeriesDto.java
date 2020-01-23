package com.gabriel.scavassa.marvelapi.dtos;

import com.gabriel.scavassa.marvelapi.domain.Image;
import com.gabriel.scavassa.marvelapi.domain.Series;
import com.gabriel.scavassa.marvelapi.domain.Url;
import com.gabriel.scavassa.marvelapi.domain.summaries.EventSumary;
import com.gabriel.scavassa.marvelapi.dtos.lists.*;
import com.gabriel.scavassa.marvelapi.util.converters.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class SeriesDto {
    private Integer id;
    private String title;
    private String description;
    private String resourceUrl;
    private Url[] url = new Url[10];
    private int startYear;
    private int endYear;
    private String rating;
    private LocalDate modified;
    private Image thumbnail;
    private List<ComicList> comics;
    private List<StorieList> stories;
    private List<EventList> events;
    private List<CharactersList> characters;
    private List<CreatorsList> creators;
    private EventSumary next;
    private EventSumary previous;

    public SeriesDto(Series series) {
        this.id = series.getId();
        this.title = series.getTitle();
        this.description = series.getDescription();
        this.resourceUrl = series.getResourceUrl();
        this.url = series.getUrl();
        this.startYear = series.getStartYear();
        this.endYear = series.getEndYear();
        this.rating = series.getRating();
        this.modified = series.getModified();
        this.thumbnail = series.getThumbnail();
        this.comics = ComicsToComicsListConverter.comicsToComicList(series.getComics());
        this.stories = StoriesToStoriesListConverter.storiesToStorieList(series.getStories());
        this.events = EventsToEventsListConverter.eventToEventList(series.getEvents());
        this.characters = CharactersToCharactersListConverter.charactersToCharacterList(series.getCharacters());
        this.creators = CreatorsToCreatorsListConverter.comicsToComicList(series.getCreators());
        this.next = series.getNext();
        this.previous = series.getPrevious();
    }
}
