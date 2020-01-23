package com.gabriel.scavassa.marvelapi.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.Character;
import com.gabriel.scavassa.marvelapi.domain.*;
import com.gabriel.scavassa.marvelapi.domain.comic.Comic;

import java.time.LocalDate;

public class CharacterTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Character.class).addTemplate("valid character", new Rule() {
            {
                add("name", "Hulk");
                add("description", "Green");
                add("modified", LocalDate.of(2020, 05, 05));
                add("resourceURI", "Https://Hulk");
                add("url", new Url[10]);
                add("thumbnail", one(Image.class, "valid image"));
                add("comics", has(1).of(Comic.class, "valid comic"));
                add("stories", has(1).of(Stories.class, "valid stories"));
                add("events", has(1).of(Event.class, "valid event"));
                add("series", has(1).of(Series.class, "valid series"));
            }
        }).addTemplate("valid complete character", new Rule() {
            {
                add("id", 1);
                add("name", "Hulk");
                add("description", "Green");
                add("modified", LocalDate.of(2020, 01, 23));
                add("resourceURI", "Https://Hulk");
                add("url", new Url[1]);
                add("thumbnail", one(Image.class, "valid image"));
                add("comics", has(1).of(Comic.class, "valid comic"));
                add("stories", has(1).of(Stories.class, "valid stories"));
                add("events", has(1).of(Event.class, "valid event"));
                add("series", has(1).of(Series.class, "valid series"));
            }
        });
    }
}
