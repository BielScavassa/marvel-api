package com.gabriel.scavassa.marvelapi.templates.dtos.lists;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;
import com.gabriel.scavassa.marvelapi.dtos.lists.ComicList;

public class ComicListTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(ComicList.class).addTemplate("valid comic list", new Rule() {
            {
                add("avaliable", 1);
                add("returned", 1);
                add("collectionURI", "collectionURI");
                add("items", new ComicSumary[10]);
                ;
            }
        });
    }

}
