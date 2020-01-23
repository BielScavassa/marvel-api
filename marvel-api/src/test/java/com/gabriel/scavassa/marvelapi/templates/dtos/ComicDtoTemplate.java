package com.gabriel.scavassa.marvelapi.templates.dtos;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.Image;
import com.gabriel.scavassa.marvelapi.domain.Url;
import com.gabriel.scavassa.marvelapi.domain.comic.ComicDate;
import com.gabriel.scavassa.marvelapi.domain.comic.ComicPrice;
import com.gabriel.scavassa.marvelapi.domain.comic.TextObjects;
import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;
import com.gabriel.scavassa.marvelapi.dtos.ComicDto;
import com.gabriel.scavassa.marvelapi.dtos.lists.*;

import java.time.LocalDate;

public class ComicDtoTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(ComicDto.class).addTemplate("valid comic dto", new Rule() {
            {
                add("id", 1);
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
                add("creators", has(1).of(CreatorsList.class, "valid creator list"));
                add("characters", has(1).of(CharactersList.class, "valid character list"));
                add("stories", has(1).of(StorieList.class, "valid storie list"));
                add("events", has(1).of(EventList.class, "valid event list"));
                add("series", has(1).of(SeriesList.class, "valid series list"));
            }
        });
    }
}
