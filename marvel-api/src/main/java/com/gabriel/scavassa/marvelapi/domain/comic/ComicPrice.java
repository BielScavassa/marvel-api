package com.gabriel.scavassa.marvelapi.domain.comic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comic_price")
public class ComicPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comic_price_id")
    private Integer id;
    private String type;
    private float price;

}
