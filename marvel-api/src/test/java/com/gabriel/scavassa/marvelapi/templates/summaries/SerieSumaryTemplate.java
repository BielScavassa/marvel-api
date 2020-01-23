package com.gabriel.scavassa.marvelapi.templates.summaries;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.dtos.summaries.SeriesSummary;

public class SerieSumaryTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(SeriesSummary.class).addTemplate("valid serie sumary", new Rule() {
            {
                add("id", null);
                add("name", "Canonic Sumary");
                add("type", "type");
                ;
            }
        });
    }

}
