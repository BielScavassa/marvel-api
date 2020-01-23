package com.gabriel.scavassa.marvelapi.templates.summaries;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.summaries.EventSumary;

public class EventSummaryTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(EventSumary.class).addTemplate("valid event summary", new Rule() {
            {
                add("id", 1);
                add("resourceURI", "Https://ressourcenextEventUri");
                add("name", "Hulk event 2.0");
                ;
            }
        });
    }

}
