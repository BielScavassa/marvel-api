package com.gabriel.scavassa.marvelapi.templates.dtos;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.Image;
import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;
import com.gabriel.scavassa.marvelapi.dtos.SeriesDto;
import com.gabriel.scavassa.marvelapi.dtos.StoriesDto;
import com.gabriel.scavassa.marvelapi.dtos.lists.*;

import java.time.LocalDate;

public class StoriesDtoTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(StoriesDto.class).addTemplate("valid stories dto", new Rule() {
            {
                add("id", 1);
                add("title", "title");
                add("description", "description");
                add("resourceUrl", "Https://Hulk");
                add("type", "type");
                add("modified", LocalDate.of(2020, 05, 05));
                add("thumbnail", one(Image.class, "valid image"));
                add("comics", has(1).of(ComicList.class, "valid comic list"));
                add("series", has(1).of(SeriesList.class, "valid series list"));
                add("events", has(1).of(EventList.class, "valid event list"));
                add("characters", has(1).of(CharactersList.class, "valid character list"));
                add("creators", has(1).of(CreatorsList.class, "valid creator list"));
                add("originalisuue", one(ComicSumary.class, "valid comic summary"));
            }
        });
    }
}
