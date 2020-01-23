package com.gabriel.scavassa.marvelapi.templates.summaries;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.dtos.summaries.CreatorSummary;

public class CreatorSummaryTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(CreatorSummary.class).addTemplate("valid creator summary", new Rule() {
            {
                add("id", 1);
                add("name", "Canonic Sumary");
                add("ressourceURI", "ressourceURI");
                add("role", "role");
                ;
            }
        });
    }

}
