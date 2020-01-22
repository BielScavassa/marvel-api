package com.gabriel.scavassa.marvelapi.domain;

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
    @ManyToMany(mappedBy = "stories")
    private List<Comic> comics;
    @ManyToMany(mappedBy = "stories")
    private List<Character> characters;
    @OneToOne
    private ComicSumary originalisuue;
}
