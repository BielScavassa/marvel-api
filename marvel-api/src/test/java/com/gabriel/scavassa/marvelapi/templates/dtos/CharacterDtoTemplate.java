package com.gabriel.scavassa.marvelapi.templates.dtos;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.Image;
import com.gabriel.scavassa.marvelapi.domain.Url;
import com.gabriel.scavassa.marvelapi.dtos.CharacterDto;
import com.gabriel.scavassa.marvelapi.dtos.lists.ComicList;
import com.gabriel.scavassa.marvelapi.dtos.lists.EventList;
import com.gabriel.scavassa.marvelapi.dtos.lists.SeriesList;
import com.gabriel.scavassa.marvelapi.dtos.lists.StorieList;

import java.time.LocalDate;

public class CharacterDtoTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(CharacterDto.class).addTemplate("valid character dto", new Rule() {
            {
                add("id", 1);
                add("name", "Hulk");
                add("description", "Green");
                add("modified", LocalDate.of(2020, 05, 05));
                add("resourceURI", "Https://Hulk");
                add("url", new Url[10]);
                add("thumbnail", one(Image.class, "valid image"));
                add("comics", has(1).of(ComicList.class, "valid comic list"));
                add("stories", has(1).of(StorieList.class, "valid storie list"));
                add("events", has(1).of(EventList.class, "valid event list"));
                add("series", has(1).of(SeriesList.class, "valid series list"));
            }
        });
    }
}
