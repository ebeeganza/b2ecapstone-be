package net.yorksolutions.yemiakinwalepantrybe.models;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(unique = true)
    public String itemName;

    public String itemUnit;
    public String itemImg;
}
