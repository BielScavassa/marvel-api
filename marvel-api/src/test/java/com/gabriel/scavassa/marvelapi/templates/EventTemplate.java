package com.gabriel.scavassa.marvelapi.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.*;
import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.domain.comic.Comic;
import com.gabriel.scavassa.marvelapi.domain.summaries.EventSumary;
import com.gabriel.scavassa.marvelapi.dtos.EventDto;
import com.gabriel.scavassa.marvelapi.dtos.lists.*;

import java.time.LocalDate;

public class EventTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Event.class).addTemplate("valid event", new Rule() {
            {
                add("title", "title");
                add("description", "description");
                add("resourceUrl", "Https://Hulk");
                add("url", new Url[10]);
                add("modified", LocalDate.of(2020, 05, 05));
                add("start", LocalDate.of(2020, 05, 05));
                add("end", LocalDate.of(2020, 05, 05));
                add("thumbnail", one(Image.class, "valid image"));
                add("series", has(1).of(Series.class, "valid series"));
                add("creators", has(1).of(Creators.class, "valid creators"));
                add("next", one(EventSumary.class, "valid event summary"));
                add("previous", one(EventSumary.class, "valid event summary"));
            }
        });
    }
}
