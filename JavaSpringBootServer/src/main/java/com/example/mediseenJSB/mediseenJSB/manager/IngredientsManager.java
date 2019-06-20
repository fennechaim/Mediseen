package com.example.mediseenJSB.mediseenJSB.manager;

import com.example.mediseenJSB.mediseenJSB.entities.ReactionActiveIngredient;
import com.example.mediseenJSB.mediseenJSB.service.accessor.FdaServiceProvider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class IngredientsManager {

    private final FdaServiceProvider fdaServiceProvider;

    public IngredientsManager(FdaServiceProvider fdaServiceProvider) {
        this.fdaServiceProvider = fdaServiceProvider;
    }

    public List<ReactionActiveIngredient> getReactionActiveIngredients(String reactionName) {
        List<ReactionActiveIngredient> response = new ArrayList<>();

        List<ReactionActiveIngredient> result = fdaServiceProvider.getReactionActiveIngredients(reactionName);

        response = result.stream().unordered().collect(Collectors.toList()).subList(0,10);

        return response;
    }
}
