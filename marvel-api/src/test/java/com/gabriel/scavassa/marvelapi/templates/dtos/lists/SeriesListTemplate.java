package com.gabriel.scavassa.marvelapi.templates.dtos.lists;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.dtos.lists.SeriesList;
import com.gabriel.scavassa.marvelapi.dtos.summaries.SeriesSummary;

public class SeriesListTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(SeriesList.class).addTemplate("valid series list", new Rule() {
            {
                add("avaliable", 1);
                add("returned", 1);
                add("collectionURI", "collectionURI");
                add("items", new SeriesSummary[10]);
                ;
            }
        });
    }

}
