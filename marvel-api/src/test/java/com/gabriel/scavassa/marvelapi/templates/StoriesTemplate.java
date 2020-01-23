package com.gabriel.scavassa.marvelapi.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.domain.*;
import com.gabriel.scavassa.marvelapi.domain.comic.Comic;
import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;
import com.gabriel.scavassa.marvelapi.dtos.lists.EventList;

import java.time.LocalDate;

public class StoriesTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Stories.class).addTemplate("valid stories", new Rule() {
            {
                add("title", "title");
                add("description", "description");
                add("resourceUrl", "Https://Hulk");
                add("type", "type");
                add("modified", LocalDate.of(2020, 05, 05));
                add("thumbnail", one(Image.class, "valid image"));
                add("series", has(1).of(Series.class, "valid series"));
                add("events", has(1).of(EventList.class, "valid event list"));
                add("creators", has(1).of(Creators.class, "valid creators"));
                add("originalisuue", one(ComicSumary.class, "valid comic summary"));
            }
        });
    }
}
