package net.yorksolutions.yemiakinwalepantrybe.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(unique = true, nullable = false)
    public String recipeName;
    public String recipeImg;

    @ElementCollection
    public List<RecipeItems> recipeItems;

    public String recipePrep;






}
