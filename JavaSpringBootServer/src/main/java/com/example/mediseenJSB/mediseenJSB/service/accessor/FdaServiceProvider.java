package com.example.mediseenJSB.mediseenJSB.service.accessor;

import com.example.mediseenJSB.mediseenJSB.entities.ReactionActiveIngredient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FdaServiceProvider {
    private RestTemplate restTemplate;
    private HttpEntity<?> httpEntity;

    public FdaServiceProvider(RestTemplateBuilder restTemplateBuilder, HttpEntity<?> httpEntity) {
        this.restTemplate = restTemplateBuilder.build();
        this.httpEntity = httpEntity;
    }

    public List<ReactionActiveIngredient> getReactionActiveIngredients(String reactionName) {
        String fooResourceUrl
                = "https://api.fda.gov/drug/event.json?search=patient.reaction.reactionmeddrapt.exact:"+reactionName+"&count=patient.drug.activesubstance.activesubstancename.exact";
        var result
                = restTemplate.exchange(fooResourceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<ReactionActiveIngredient[]>(){});

        return Arrays.asList(result.getBody());
    }

}
