package com.gabriel.scavassa.marvelapi.dtos.lists;

import com.gabriel.scavassa.marvelapi.dtos.summaries.StorieSummary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorieList {
    private int avaliable;
    private int returned;
    private String collectionURI;
    private StorieSummary[] items;


    public void addStorieSumary(StorieSummary storieSummary, int size) {
        StorieSummary[] storieSumaries = new StorieSummary[size];
        this.items = storieSumaries;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                this.items[i] = storieSummary;
                break;
            }
        }
    }
}
