package com.gabriel.scavassa.marvelapi.templates.summaries;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.summaries.EventSumary;

public class EventSumaryTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(EventSumary.class).addTemplate("valid event sumary template", new Rule() {
            {
                add("id", null);
                add("resourceURI", "Https://ressourcenextEventUri");
                add("name", "Hulk event 2.0");
                ;
            }
        });
    }

}
