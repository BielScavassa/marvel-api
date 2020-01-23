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
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class CharacterDto implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private LocalDate modified;
    private String resourceURI;
    private Url[] url = new Url[10];
    private Image thumbnail;
    private List<ComicList> comics;
    private List<StorieList> stories;
    private List<EventList> events;
    private List<SeriesList> series;

    public CharacterDto(Character character) {
        this.id = character.getId();
        this.name = character.getName();
        this.description = character.getDescription();
        this.modified = character.getModified();
        this.resourceURI = character.getResourceURI();
        this.url = character.getUrl();
        this.thumbnail = character.getThumbnail();
        this.comics = ComicsToComicsListConverter.comicsToComicList(character.getComics());
        this.stories = StoriesToStoriesListConverter.storiesToStorieList(character.getStories());
        this.events = EventsToEventsListConverter.eventToEventList(character.getEvents());
        this.series = SeriesToSeriesListConverter.seriesToSeriesList(character.getSeries());
    }

}
