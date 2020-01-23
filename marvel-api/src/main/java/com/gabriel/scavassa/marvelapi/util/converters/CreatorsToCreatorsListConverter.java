package com.gabriel.scavassa.marvelapi.util.converters;

import com.gabriel.scavassa.marvelapi.domain.Creators;
import com.gabriel.scavassa.marvelapi.dtos.lists.CreatorsList;
import com.gabriel.scavassa.marvelapi.dtos.summaries.CreatorSummary;

import java.util.ArrayList;
import java.util.List;

public class CreatorsToCreatorsListConverter {

    static public List<CreatorsList> comicsToComicList(List<Creators> creatorsList) {
        List<CreatorsList> listOfStorieList = new ArrayList<>();
        for (Creators creators : creatorsList) {
            CreatorSummary creatorSummary = new CreatorSummary();
            CreatorsList listOfCreators = new CreatorsList();
            listOfCreators.setAvaliable(creatorsList.size());
            if (creatorsList.size() > 20)
                listOfCreators.setReturned(20);
            listOfCreators.setReturned(creatorsList.size());
            listOfCreators.setCollectionURI("Http://" + creators.getFullName() + "comicCollectionURI");
            creatorSummary.setRessourceURI(creators.getRessourceUri());
            creatorSummary.setName(creators.getFirstName());
            creatorSummary.setRole(creators.getFullName());
            listOfCreators.addCreatorSumary(creatorSummary, creatorsList.size());

            listOfStorieList.add(listOfCreators);
        }
        return listOfStorieList;
    }
}
