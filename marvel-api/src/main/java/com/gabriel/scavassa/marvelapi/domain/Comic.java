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
@Table(name = "comic")
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int digitalId;
    private String title;
    private double issueNumber;
    private String variantDescription;
    private String description;
    private LocalDate modified;
    private String isbn;
    private String upc;
    private String diamondCode;
    private String ean;
    private String issn;
    private String format;
    private int pageCount;
    @OneToMany
    @OrderColumn(name = "text_objects_id")
    private TextObjects[] textObjects = new TextObjects[10];
    private String resourceURI;
    @OneToMany
    @OrderColumn(name = "comic_date_id")
    private ComicDate comicDate[] = new ComicDate[10];
//    private ComicPrice comicPrice[];
    @ManyToMany(mappedBy = "comics")
    private List<Character> characters;


}
