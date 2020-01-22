package com.gabriel.scavassa.marvelapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comic_sumary")
public class ComicSumary {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comic_sumary_id")
    private Long id;
    private String resource;
    private String name;
}
