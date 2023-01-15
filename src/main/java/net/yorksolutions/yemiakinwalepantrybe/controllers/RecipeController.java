package net.yorksolutions.yemiakinwalepantrybe.controllers;

import net.yorksolutions.yemiakinwalepantrybe.models.Recipe;
import net.yorksolutions.yemiakinwalepantrybe.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/recipe")
@CrossOrigin
public class RecipeController {

    private final RecipeService recipeService;

@Autowired
    public RecipeController(RecipeService recipeService ) { this.recipeService = recipeService; }

    @PostMapping
    public void newRecipe(@RequestBody Recipe recipe) {
        try {
            recipeService.newRecipe(recipe);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public Iterable<Recipe> getAllRecipe(Recipe recipe) {
        try {
            return recipeService.getAllRecipe(recipe);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        try {
            recipeService.deleteRecipe(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public Recipe modifyRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        try {
            return recipeService.modifyRecipe(id, recipe);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
