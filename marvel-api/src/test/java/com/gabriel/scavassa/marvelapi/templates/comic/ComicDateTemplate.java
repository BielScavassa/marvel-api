package com.gabriel.scavassa.marvelapi.templates.comic;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;

import java.time.LocalDate;

public class ComicDateTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(ComicSumary.class).addTemplate("valid comic sumary", new Rule() {
            {
                add("id", 1);
                add("lenguage", "t-Br");
                add("date", LocalDate.now());
                ;
            }
        });
    }

}
