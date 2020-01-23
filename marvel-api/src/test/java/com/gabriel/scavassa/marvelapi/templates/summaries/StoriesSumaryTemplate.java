package com.gabriel.scavassa.marvelapi.templates.summaries;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.dtos.summaries.StorieSummary;

public class StoriesSumaryTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(StorieSummary.class).addTemplate("valid storie sumary", new Rule() {
            {
                add("id", null);
                add("name", "Canonic Sumary");
                add("type", "type");
                ;
            }
        });
    }

}
