package net.yorksolutions.yemiakinwalepantrybe.services;

import net.yorksolutions.yemiakinwalepantrybe.models.Item;
import net.yorksolutions.yemiakinwalepantrybe.models.Recipe;
import net.yorksolutions.yemiakinwalepantrybe.repositories.ItemListRepository;
import net.yorksolutions.yemiakinwalepantrybe.repositories.ItemRepository;
import net.yorksolutions.yemiakinwalepantrybe.repositories.MemberRepository;
import net.yorksolutions.yemiakinwalepantrybe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {

    private final MemberRepository memberRepository;

    private final ItemRepository itemRepository;

    private final ItemListRepository itemListRepository;

    private final RecipeRepository recipeRepository;

    public RecipeService(MemberRepository memberRepository, ItemRepository itemRepository,
                       ItemListRepository itemListRepository, RecipeRepository recipeRepository) {
        this.memberRepository = memberRepository;
        this.itemRepository = itemRepository;
        this.itemListRepository = itemListRepository;
        this.recipeRepository = recipeRepository;
    }

    public Iterable<Recipe> getAllRecipe(Recipe recipe) {
        return recipeRepository.findAll();}

    public Recipe newRecipe(Recipe recipe) throws Exception {
        if (recipeRepository.findRecipeByName(recipe.recipeName).isPresent())
            throw new Exception();

        return recipeRepository.save(recipe);
    }

//    public Item updateRecipe(Recipe recipe) throws Exception {
//        if (recipeRepository.findRecipeByName(recipe.recipeName).isEmpty())
//            throw new Exception();
//
//        return null;
//    }

    public void deleteRecipe(Long id) throws Exception {
        Optional <Recipe> recipeToDelete = this.recipeRepository.findById(id);
        if (recipeToDelete.isEmpty()) {
            throw new Exception();
        }

        recipeRepository.deleteById(id);
        }

}
