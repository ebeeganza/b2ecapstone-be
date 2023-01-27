package net.yorksolutions.yemiakinwalepantrybe.models;

import javax.persistence.*;
import java.util.List;

@Embeddable
public class RecipeItems {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    public Long id;
    @Column(unique = true)
    public String recipeItemName;
    public int unitNeeded;

}
