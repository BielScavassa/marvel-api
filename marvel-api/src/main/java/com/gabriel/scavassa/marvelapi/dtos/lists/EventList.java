package com.gabriel.scavassa.marvelapi.dtos.lists;

import com.gabriel.scavassa.marvelapi.domain.summaries.EventSumary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventList {
    private int avaliable;
    private int returned;
    private String collectionURI;
    private EventSumary[] items;

    public void addEventSumary(EventSumary eventSumary, int size) {
        EventSumary[] storieSumaries = new EventSumary[size];
        this.items = storieSumaries;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                this.items[i] = eventSumary;
                break;
            }
        }
    }
}

