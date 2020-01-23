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
                add("name", "Hulk");
                add("description", "Green");
                add("modified", LocalDate.now());
                add("resourceURI", "Https://Hulk");
                add("fullName", one(Url.class, "valid url"));
                add("thumbnail", one(Image.class, "valid image"));
                add("comicList", has(1).of(ComicList.class, "valid comic list"));
                add("storieList", has(1).of(StorieList.class, "valid storie list"));
                add("eventList", has(1).of(EventList.class, "valid event list"));
                add("seriesList", has(1).of(SeriesList.class, "valid series list"));
            }
        });
    }
}
