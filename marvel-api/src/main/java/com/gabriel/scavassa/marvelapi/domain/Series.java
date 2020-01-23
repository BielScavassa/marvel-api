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
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String resourceUrl;
    @OneToMany
    @OrderColumn(name = "url_id")
    private Url[] url = new Url[10];
    private int startYear;
    private int endYear;
    private String rating;
    private LocalDate modified;
    @OneToOne
    private Image thumbnail;
    @ManyToMany(mappedBy = "series")
    private List<Comic> comics;
    @ManyToMany(mappedBy = "series")
    private List<Stories> stories;
    @ManyToMany(mappedBy = "series")
    private List<Event> events;
    @ManyToMany(mappedBy = "stories")
    private List<Character> characters;
    @ManyToMany
    @JoinTable(name = "Series_Creators",
            joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "creators_id"))
    private List<Creators> creators;
    @OneToOne
    private EventSumary next;
    @OneToOne
    private EventSumary previous;
}
