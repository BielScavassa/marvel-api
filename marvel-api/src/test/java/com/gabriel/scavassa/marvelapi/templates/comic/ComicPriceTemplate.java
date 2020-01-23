package com.gabriel.scavassa.marvelapi.templates.comic;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;

public class ComicPriceTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(ComicSumary.class).addTemplate("valid comic sumary", new Rule() {
            {
                add("id", null);
                add("type", "Digital Price");
                add("price", 35.00f);
                ;
            }
        });
    }

}
