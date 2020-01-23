package com.gabriel.scavassa.marvelapi.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.gabriel.scavassa.marvelapi.domain.Url;

public class UrlTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Url.class).addTemplate("valid url template", new Rule() {
            {
                add("id", null);
                add("type", "Urls");
                add("url", "Https://hulkurls");
            }
        });
    }

}
