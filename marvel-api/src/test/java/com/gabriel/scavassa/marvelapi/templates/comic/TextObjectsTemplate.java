package com.gabriel.scavassa.marvelapi.templates.comic;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.comic.TextObjects;

public class TextObjectsTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(TextObjects.class).addTemplate("valid text objects", new Rule() {
            {
                add("id", 1);
                add("type", "Text");
                add("lenguage", "t-Br");
                add("text", "Smash Smash and Smash");
                ;
            }
        });
    }

}
