package com.gabriel.scavassa.marvelapi.domain;

import com.gabriel.scavassa.marvelapi.domain.comic.Comic;
import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;
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
@Table(name = "stories")
public class Stories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String resourceUrl;
    private String type;
    private LocalDate modified;
    @OneToOne
    private Image thumbnail;
    @ManyToMany(mappedBy = "stories")
    private List<Comic> comics;
    @ManyToMany
    @JoinTable(name = "Stories_Series",
            joinColumns = @JoinColumn(name = "stories_id"),
            inverseJoinColumns = @JoinColumn(name = "series_id"))
    private List<Series> series;
    @ManyToMany
    @JoinTable(name = "Stories_Events",
            joinColumns = @JoinColumn(name = "stories_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<Event> events;
    @ManyToMany(mappedBy = "stories")
    private List<Character> characters;
    @ManyToMany
    @JoinTable(name = "Stories_Creators",
            joinColumns = @JoinColumn(name = "stories_id"),
            inverseJoinColumns = @JoinColumn(name = "creators_id"))
    private List<Creators> creators;
    @OneToOne
    private ComicSumary originalisuue;
}
