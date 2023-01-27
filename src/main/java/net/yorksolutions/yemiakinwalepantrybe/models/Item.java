package net.yorksolutions.yemiakinwalepantrybe.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(unique = true, nullable = false)
    public String itemName;
    @Column(nullable = false)
    public int itemUnit;
    public String itemImg;

}


