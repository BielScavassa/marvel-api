package com.gabriel.scavassa.marvelapi.templates.summaries;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;

public class ComicSummaryTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(ComicSumary.class).addTemplate("valid comic summary", new Rule() {
            {
                add("id", 1);
                add("resourceURI", "Https://ressourceSumaryUri");
                add("name", "Canonic Sumary");
                ;
            }
        });
    }

}
