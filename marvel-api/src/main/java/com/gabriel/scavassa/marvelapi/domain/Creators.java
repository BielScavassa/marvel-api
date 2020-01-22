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
@Table(name = "creators")
public class Creators {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String fullName;
    private LocalDate modified;
    private String ressourceUri;
    @OneToMany
    @OrderColumn(name = "url_id")
    private Url[] url = new Url[10];
    @OneToOne
    private Image thumbnail;
    @ManyToMany(mappedBy = "creators")
    private List<Series> series;
    @ManyToMany(mappedBy = "creators")
    private List<Stories> stories;
    @ManyToMany(mappedBy = "creators")
    private List<Comic> comics;
    @ManyToMany(mappedBy = "creators")
    private List<Event> events;
}
