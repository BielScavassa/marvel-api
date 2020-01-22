package com.gabriel.scavassa.marvelapi.domain;

import com.gabriel.scavassa.marvelapi.domain.comic.Comic;
import com.gabriel.scavassa.marvelapi.domain.summaries.EventSumary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long id;
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
    @ManyToMany(mappedBy = "series")
    private List<Comic> comics;
    @ManyToMany(mappedBy = "series")
    private List<Stories> stories;
    @ManyToMany(mappedBy = "series")
    private List<Event> events;
    @ManyToMany(mappedBy = "stories")
    private List<Character> characters;
    @OneToOne
    private EventSumary next;
    @OneToOne
    private EventSumary previous;
}
