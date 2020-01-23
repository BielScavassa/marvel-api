package com.gabriel.scavassa.marvelapi.templates.dtos.lists;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.dtos.lists.CharactersList;
import com.gabriel.scavassa.marvelapi.dtos.lists.ComicList;
import com.gabriel.scavassa.marvelapi.dtos.summaries.CharactersSummary;

public class CharactersListTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(CharactersList.class).addTemplate("valid character list", new Rule() {
            {
                add("avaliable", 1);
                add("returned", 1);
                add("collectionURI", "collectionURI");
                add("items", new CharactersSummary[10]);
                ;
            }
        });
    }

}
