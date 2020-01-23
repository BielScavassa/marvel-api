package com.gabriel.scavassa.marvelapi.templates.comic;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.*;
import com.gabriel.scavassa.marvelapi.domain.comic.Comic;
import com.gabriel.scavassa.marvelapi.domain.comic.ComicDate;
import com.gabriel.scavassa.marvelapi.domain.comic.ComicPrice;
import com.gabriel.scavassa.marvelapi.domain.comic.TextObjects;
import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;

import java.lang.Character;
import java.time.LocalDate;

public class ComicTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Comic.class).addTemplate("valid comic", new Rule() {
            {
                add("digitalId", 1);
                add("title", "title");
                add("issueNumber", 22.2);
                add("variantDescription", "variantDescription");
                add("description", "description");
                add("modified", LocalDate.of(2020, 05, 05));
                add("isbn", "isbn");
                add("upc", "upc");
                add("diamondCode", "diamondCode");
                add("ean", "ean");
                add("issn", "issn");
                add("format", "format");
                add("pageCount", 5);
                add("textObjects", new TextObjects[10]);
                add("resourceURI", "resourceURI");
                add("url", new Url[10]);
                add("variants", new ComicSumary[10]);
                add("collections", new ComicSumary[10]);
                add("collectedissues", new ComicSumary[10]);
                add("dates", new ComicDate[10]);
                add("prices", new ComicPrice[10]);
                add("thumbnail", one(Image.class, "valid image"));
                add("images", new Image[10]);
                add("creators", has(1).of(Creators.class, "valid creators"));
                add("stories", has(1).of(Stories.class, "valid stories"));
                add("events", has(1).of(Event.class, "valid event"));
                add("series", has(1).of(Series.class, "valid series"));
            }
        });
    }
}
