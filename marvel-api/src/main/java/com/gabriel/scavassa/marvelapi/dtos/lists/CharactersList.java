package com.gabriel.scavassa.marvelapi.dtos.lists;

import com.gabriel.scavassa.marvelapi.dtos.summaries.CharactersSummary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharactersList {
    private int avaliable;
    private int returned;
    private String collectionURI;
    private CharactersSummary[] items;


    public void addCharacterSumary(CharactersSummary charactersSummary, int size) {
        CharactersSummary[] charactersSummaries = new CharactersSummary[size];
        this.items = charactersSummaries;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                this.items[i] = charactersSummary;
                break;
            }
        }
    }
}
