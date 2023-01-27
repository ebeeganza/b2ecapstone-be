package net.yorksolutions.yemiakinwalepantrybe.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(unique = true)
    public String name;

    public String password;
    public String passwordRepeat;

    @OneToMany
    public List <Recipe> Recipes;

}
