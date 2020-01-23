package com.gabriel.scavassa.marvelapi.util.converters;

import com.gabriel.scavassa.marvelapi.domain.Stories;
import com.gabriel.scavassa.marvelapi.dtos.lists.StorieList;
import com.gabriel.scavassa.marvelapi.dtos.summaries.StorieSummary;

import java.util.ArrayList;
import java.util.List;

public class StoriesToStoriesListConverter {

    static public List<StorieList> storiesToStorieList(List<Stories> stories) {
        List<StorieList> listOfStorieList = new ArrayList<>();
        for (Stories storie : stories) {
            StorieSummary storieSummary = new StorieSummary();
            StorieList storieList = new StorieList();
            storieList.setAvaliable(stories.size());
            if (stories.size() > 20)
                storieList.setReturned(20);
            storieList.setReturned(stories.size());
            storieList.setCollectionURI("Http://" + storie.getTitle() + "comicCollectionURI");
            storieSummary.setRessourceURI(storie.getResourceUrl());
            storieSummary.setName(storie.getTitle());
            storieSummary.setType(storie.getType());
            storieList.addStorieSumary(storieSummary, stories.size());

            listOfStorieList.add(storieList);
        }
        return listOfStorieList;
    }
}
