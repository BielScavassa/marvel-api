package com.gabriel.scavassa.marvelapi.util.converters;

import com.gabriel.scavassa.marvelapi.domain.comic.Comic;
import com.gabriel.scavassa.marvelapi.dtos.lists.ComicList;

import java.util.ArrayList;
import java.util.List;

public class ComicsToComicsListConverter {

    static public List<ComicList> comicsToComicList(List<Comic> comics) {
        List<ComicList> listOfComicsList = new ArrayList<>();
        for (Comic comic : comics) {
            ComicList comicList = new ComicList();
            comicList.setAvaliable(comics.size());
            if (comics.size() > 20)
                comicList.setReturned(20);
            comicList.setReturned(comics.size());
            comicList.setCollectionURI("Http://" + comic.getTitle() + "comicCollectionURI");
            comicList.setItems(comic.getCollectedissues());

            listOfComicsList.add(comicList);
        }
        return listOfComicsList;
    }
}
