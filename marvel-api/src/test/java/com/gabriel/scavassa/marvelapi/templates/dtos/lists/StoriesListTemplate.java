package com.gabriel.scavassa.marvelapi.templates.dtos.lists;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.dtos.lists.StorieList;
import com.gabriel.scavassa.marvelapi.dtos.summaries.StorieSummary;

public class StoriesListTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(StorieList.class).addTemplate("valid storie list", new Rule() {
            {
                add("avaliable", 1);
                add("returned", 1);
                add("collectionURI", "collectionURI");
                add("items", new StorieSummary[10]);
                ;
            }
        });
    }

}
