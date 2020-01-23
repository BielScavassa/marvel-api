package com.gabriel.scavassa.marvelapi.dtos;

import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.domain.Image;
import com.gabriel.scavassa.marvelapi.domain.Url;
import com.gabriel.scavassa.marvelapi.dtos.lists.ComicList;
import com.gabriel.scavassa.marvelapi.dtos.lists.EventList;
import com.gabriel.scavassa.marvelapi.dtos.lists.SeriesList;
import com.gabriel.scavassa.marvelapi.dtos.lists.StorieList;
import com.gabriel.scavassa.marvelapi.util.converters.ComicsToComicsListConverter;
import com.gabriel.scavassa.marvelapi.util.converters.EventsToEventsListConverter;
import com.gabriel.scavassa.marvelapi.util.converters.SeriesToSeriesListConverter;
import com.gabriel.scavassa.marvelapi.util.converters.StoriesToStoriesListConverter;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class CharacterDto implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private LocalDate modified;
    private String resourceURI;
    private Url[] url = new Url[10];
    private Image thumbnail;
    private List<ComicList> comicList;
    private List<StorieList> storieList;
    private List<EventList> eventList;
    private List<SeriesList> seriesList;

    public CharacterDto(Character character) {
        this.id = character.getId();
        this.name = character.getName();
        this.description = character.getDescription();
        this.modified = character.getModified();
        this.resourceURI = character.getResourceURI();
        this.url = character.getUrl();
        this.thumbnail = character.getThumbnail();
        this.comicList = ComicsToComicsListConverter.comicsToComicList(character.getComics());
        this.storieList = StoriesToStoriesListConverter.storiesToStorieList(character.getStories());
        this.eventList = EventsToEventsListConverter.eventToEventList(character.getEvents());
        this.seriesList = SeriesToSeriesListConverter.seriesToSeriesList(character.getSeries());
    }

}
