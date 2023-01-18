package net.yorksolutions.yemiakinwalepantrybe.services;

import net.yorksolutions.yemiakinwalepantrybe.models.Item;
import net.yorksolutions.yemiakinwalepantrybe.models.Recipe;
import net.yorksolutions.yemiakinwalepantrybe.repositories.ItemRepository;
import net.yorksolutions.yemiakinwalepantrybe.repositories.MemberRepository;
import net.yorksolutions.yemiakinwalepantrybe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {

    private final MemberRepository memberRepository;

    private final ItemRepository itemRepository;


    private final RecipeRepository recipeRepository;

    public RecipeService(MemberRepository memberRepository, ItemRepository itemRepository,
                        RecipeRepository recipeRepository) {
        this.memberRepository = memberRepository;
        this.itemRepository = itemRepository;
        this.recipeRepository = recipeRepository;
    }

    public Iterable<Recipe> getAllRecipe(Recipe recipe) {
        return recipeRepository.findAll();}

    public Recipe newRecipe(Recipe recipe) throws Exception {
        if (recipeRepository.findByRecipeName(recipe.recipeName).isPresent())
            throw new Exception();

        return recipeRepository.save(recipe);
    }


    public void deleteRecipe(Long id) throws Exception {
        Optional <Recipe> recipeToDelete = this.recipeRepository.findById(id);
        if (recipeToDelete.isEmpty()) {
            throw new Exception();
        }

        recipeRepository.deleteById(id);
        }


    public Recipe modifyRecipe(Long id, Recipe recipe) throws Exception {
        if (recipeRepository.findByRecipeName(recipe.recipeName).isEmpty())
            throw new Exception();

        final var modifiedRecipe = recipeRepository.findByRecipeName(recipe.recipeName).orElseThrow();
        modifiedRecipe.recipeName = recipe.recipeName;
        modifiedRecipe.recipeImg = recipe.recipeImg;
        modifiedRecipe.recipeItems = recipe.recipeItems;
        modifiedRecipe.recipePrep = recipe.recipePrep;

        return recipeRepository.save(modifiedRecipe);

    }



}
