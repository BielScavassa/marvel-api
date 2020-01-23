package com.gabriel.scavassa.marvelapi.util.converters;

import com.gabriel.scavassa.marvelapi.domain.Series;
import com.gabriel.scavassa.marvelapi.dtos.lists.SeriesList;
import com.gabriel.scavassa.marvelapi.dtos.summaries.SeriesSummary;

import java.util.ArrayList;
import java.util.List;

public class SeriesToSeriesListConverter {

    static public List<SeriesList> seriesToSeriesList(List<Series> series) {
        List<SeriesList> listOfSeriesList = new ArrayList<>();
        for (Series serie : series) {
            SeriesSummary seriesSummary = new SeriesSummary();
            SeriesList seriesList = new SeriesList();
            seriesList.setAvaliable(series.size());
            if (series.size() > 20)
                seriesList.setReturned(20);
            seriesList.setReturned(series.size());
            seriesList.setCollectionURI("Http://" + serie.getTitle() + "comicCollectionURI");
            seriesSummary.setName(serie.getTitle());
            seriesSummary.setRessourceURI(serie.getResourceUrl());
            seriesList.addSerieSumary(seriesSummary, series.size());

            listOfSeriesList.add(seriesList);
        }
        return listOfSeriesList;
    }
}
