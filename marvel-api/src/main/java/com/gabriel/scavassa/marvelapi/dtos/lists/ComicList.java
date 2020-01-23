package com.gabriel.scavassa.marvelapi.dtos.lists;

import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComicList {
    private int avaliable;
    private int returned;
    private String collectionURI;
    private ComicSumary[] items = new ComicSumary[10];

}

