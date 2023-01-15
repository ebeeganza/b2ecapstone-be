package net.yorksolutions.yemiakinwalepantrybe.models;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(unique = true)
    public String itemName;

    public int itemUnit;
    public String itemImg;
}
