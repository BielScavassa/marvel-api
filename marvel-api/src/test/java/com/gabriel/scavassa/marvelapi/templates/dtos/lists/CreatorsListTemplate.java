package com.gabriel.scavassa.marvelapi.templates.dtos.lists;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.dtos.lists.CreatorsList;
import com.gabriel.scavassa.marvelapi.dtos.summaries.CreatorSummary;

public class CreatorsListTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(CreatorsList.class).addTemplate("valid creator list", new Rule() {
            {
                add("avaliable", 1);
                add("returned", 1);
                add("collectionURI", "collectionURI");
                add("items", new CreatorSummary[10]);
                ;
            }
        });
    }

}
