package com.gabriel.scavassa.marvelapi.templates.summaries;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.dtos.summaries.CreatorSummary;

public class CreatorSumaryTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(CreatorSummary.class).addTemplate("valid creator sumary", new Rule() {
            {
                add("id", null);
                add("name", "Canonic Sumary");
                add("role", "role");
                ;
            }
        });
    }

}
