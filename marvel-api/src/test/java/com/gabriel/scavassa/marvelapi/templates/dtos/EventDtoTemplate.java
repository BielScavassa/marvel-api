package com.gabriel.scavassa.marvelapi.templates.dtos;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.Image;
import com.gabriel.scavassa.marvelapi.domain.Url;
import com.gabriel.scavassa.marvelapi.domain.summaries.EventSumary;
import com.gabriel.scavassa.marvelapi.dtos.EventDto;
import com.gabriel.scavassa.marvelapi.dtos.lists.*;

import java.time.LocalDate;

public class EventDtoTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(EventDto.class).addTemplate("valid event dto", new Rule() {
            {
                add("id", 1);
                add("title", "title");
                add("description", "description");
                add("resourceUrl", "Https://Hulk");
                add("url", new Url[10]);
                add("modified", LocalDate.of(2020, 05, 05));
                add("start", LocalDate.of(2020, 05, 05));
                add("end", LocalDate.of(2020, 05, 05));
                add("thumbnail", one(Image.class, "valid image"));
                add("comics", has(1).of(ComicList.class, "valid comic list"));
                add("stories", has(1).of(StorieList.class, "valid storie list"));
                add("series", has(1).of(SeriesList.class, "valid series list"));
                add("characters", has(1).of(CharactersList.class, "valid character list"));
                add("creators", has(1).of(CreatorsList.class, "valid creator list"));
                add("next", one(EventSumary.class, "valid event summary"));
                add("previous", one(EventSumary.class, "valid event summary"));
            }
        });
    }
}
