package com.gabriel.scavassa.marvelapi.dtos.lists;

import com.gabriel.scavassa.marvelapi.dtos.summaries.SeriesSummary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeriesList {
    private int avaliable;
    private int returned;
    private String collectionURI;
    private SeriesSummary[] items;


    public void addSerieSumary(SeriesSummary seriesSummary, int size) {
        SeriesSummary[] seriesSummaries = new SeriesSummary[size];
        this.items = seriesSummaries;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                this.items[i] = seriesSummary;
                break;
            }
        }
    }
}
