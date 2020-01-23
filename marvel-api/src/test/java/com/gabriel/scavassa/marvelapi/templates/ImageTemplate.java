package com.gabriel.scavassa.marvelapi.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.Image;
import com.gabriel.scavassa.marvelapi.domain.Url;

public class ImageTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Image.class).addTemplate("valid image template", new Rule() {
            {
                add("id", null);
                add("type", "Https://imageurl");
                add("extension", "C://hulk/images");
                ;
            }
        });
    }

}
