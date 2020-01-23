package com.gabriel.scavassa.marvelapi.dtos.lists;

import com.gabriel.scavassa.marvelapi.dtos.summaries.CreatorSummary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatorsList {
    private int avaliable;
    private int returned;
    private String collectionURI;
    private CreatorSummary[] items;

    public void addCreatorSumary(CreatorSummary creatorSummary, int size) {
        CreatorSummary[] creatorSummaries = new CreatorSummary[size];
        this.items = creatorSummaries;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                this.items[i] = creatorSummary;
                break;
            }
        }
    }

}

