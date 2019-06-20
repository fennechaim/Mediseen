package com.example.mediseenJSB.mediseenJSB.rest.api;

import com.example.mediseenJSB.mediseenJSB.entities.ReactionActiveIngredient;
import com.example.mediseenJSB.mediseenJSB.manager.IngredientsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/ingredients")
public class MediseenController {

    @Autowired
    private IngredientsManager ingredientsManager;

    @GetMapping(value = "reaction/{reactionName}")
    public ResponseEntity<List<ReactionActiveIngredient>> getReactionActiveIngredients(@PathVariable("reactionName") String reactionName) {

        List<ReactionActiveIngredient> response = ingredientsManager.getReactionActiveIngredients(reactionName);

        return new ResponseEntity(response, HttpStatus.OK);
    }
}
