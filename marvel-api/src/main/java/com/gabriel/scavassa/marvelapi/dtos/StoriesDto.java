package com.gabriel.scavassa.marvelapi.dtos;

import com.gabriel.scavassa.marvelapi.domain.Image;
import com.gabriel.scavassa.marvelapi.domain.Stories;
import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;
import com.gabriel.scavassa.marvelapi.dtos.lists.*;
import com.gabriel.scavassa.marvelapi.util.converters.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StoriesDto {
    private Integer id;
    private String title;
    private String description;
    private String resourceUrl;
    private String type;
    private LocalDate modified;
    private Image thumbnail;
    private List<ComicList> comics;
    private List<SeriesList> series;
    private List<EventList> events;
    private List<CharactersList> characters;
    private List<CreatorsList> creators;
    private ComicSumary originalisuue;

    public StoriesDto(Stories stories) {
        this.id = stories.getId();
        this.title = stories.getTitle();
        this.description = stories.getDescription();
        this.resourceUrl = stories.getResourceUrl();
        this.type = stories.getType();
        this.modified = stories.getModified();
        this.thumbnail = stories.getThumbnail();
        this.comics = ComicsToComicsListConverter.comicsToComicList(stories.getComics());
        this.series = SeriesToSeriesListConverter.seriesToSeriesList(stories.getSeries());
        this.events = EventsToEventsListConverter.eventToEventList(stories.getEvents());
        this.characters = CharactersToCharactersListConverter.charactersToCharacterList(stories.getCharacters());
        this.creators = CreatorsToCreatorsListConverter.comicsToComicList(stories.getCreators());
        this.originalisuue = stories.getOriginalisuue();
    }
}
