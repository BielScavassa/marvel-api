package com.gabriel.scavassa.marvelapi.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.Creators;
import com.gabriel.scavassa.marvelapi.domain.Image;

public class CreatorsTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Creators.class).addTemplate("valid creators template", new Rule() {
            {
                add("id", null);
                add("firstName", null);
                add("middleName", null);
                add("lastName", null);
                add("suffix", null);
                add("fullName", null);
                add("modified", null);
                add("ressourceUri", null);
                add("thumbnail", one(Image.class, "valid"));
                add("name", "Hulk event 2.0");
            }
        });
    }

}
