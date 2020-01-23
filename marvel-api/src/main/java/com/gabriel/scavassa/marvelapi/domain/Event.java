package com.gabriel.scavassa.marvelapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gabriel.scavassa.marvelapi.domain.comic.Comic;
import com.gabriel.scavassa.marvelapi.domain.summaries.EventSumary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String resourceUrl;
    @OneToMany
    @OrderColumn(name = "url_id")
    private Url[] url = new Url[10];
    private LocalDate modified;
    private LocalDate start;
    private LocalDate end;
    @OneToOne
    private Image thumbnail;
    @ManyToMany(mappedBy = "events")
    private List<Comic> comics;
    @ManyToMany(mappedBy = "events")
    private List<Stories> stories;
    @ManyToMany
    @JoinTable(name = "Event_Series",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "series_id"))
    private List<Series> series;
    @ManyToMany(mappedBy = "events")
    private List<Character> characters;
    @ManyToMany
    @JoinTable(name="Event_Creators",
            joinColumns =@JoinColumn(name  = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "creators_id"))
    private List<Creators> creators;
    @OneToOne
    private EventSumary next;
    @OneToOne
    private EventSumary previous;
}
