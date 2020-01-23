package com.gabriel.scavassa.marvelapi.templates.summaries;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;

public class ComicSumaryTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(ComicSumary.class).addTemplate("valid comic sumary", new Rule() {
            {
                add("id", null);
                add("resourceURI", "Https://ressourceSumaryUri");
                add("name", "Canonic Sumary");
                ;
            }
        });
    }

}
