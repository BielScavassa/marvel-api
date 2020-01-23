package com.gabriel.scavassa.marvelapi.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.domain.*;
import com.gabriel.scavassa.marvelapi.domain.comic.Comic;
import com.gabriel.scavassa.marvelapi.domain.summaries.EventSumary;

import java.time.LocalDate;

public class SeriesTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Series.class).addTemplate("valid series", new Rule() {
            {
                add("title", "Hulk Series");
                add("description", "Middle Name");
                add("resourceUrl", "Https://hulkCreator");
                add("url", new Url[10]);
                add("startYear", 2020);
                add("endYear", 2022);
                add("rating", "14");
                add("modified", LocalDate.of(2020, 05, 05));
                add("thumbnail", one(Image.class, "valid image"));
                add("creators", has(1).of(Creators.class, "valid creators"));
                add("next", one(EventSumary.class, "valid event summary"));
                add("previous", one(EventSumary.class, "valid event summary"));
            }
        });
    }

}
