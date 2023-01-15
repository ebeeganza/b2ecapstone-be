package net.yorksolutions.yemiakinwalepantrybe.repositories;

import net.yorksolutions.yemiakinwalepantrybe.models.Item;
import net.yorksolutions.yemiakinwalepantrybe.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findByRecipeName(String recipeName);

}
