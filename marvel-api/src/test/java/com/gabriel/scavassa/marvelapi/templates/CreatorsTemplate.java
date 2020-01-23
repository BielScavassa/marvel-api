package com.gabriel.scavassa.marvelapi.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.*;
import com.gabriel.scavassa.marvelapi.domain.comic.Comic;

import java.time.LocalDate;

public class CreatorsTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Creators.class).addTemplate("valid creators", new Rule() {
            {
                add("firstName", "First Name");
                add("middleName", "Middle Name");
                add("lastName", "Last Name");
                add("suffix", "Suffix");
                add("fullName", "Hulk Creator");
                add("modified", LocalDate.of(2020, 05, 05));
                add("ressourceUri", "Https://hulkCreator");
                add("thumbnail", one(Image.class, "valid image"));
            }
        }).addTemplate("valid complete creators", new Rule() {
            {
                add("firstName", "First Name");
                add("middleName", "Middle Name");
                add("lastName", "Last Name");
                add("suffix", "Suffix");
                add("fullName", "Hulk Creator");
                add("modified", LocalDate.of(2020, 05, 05));
                add("ressourceUri", "Https://hulkCreator");
                add("thumbnail", one(Image.class, "valid image"));
                add("comics", has(1).of(Comic.class, "valid complete comic"));
                add("stories", has(1).of(Stories.class, "valid complete storie"));
                add("events", has(1).of(Event.class, "valid complete event"));
                add("series", has(1).of(Series.class, "valid complete series"));
            }
        });
    }

}
