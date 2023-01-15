package net.yorksolutions.yemiakinwalepantrybe.models;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(unique = true)
    public String name;

    public String password;
    public String passwordRepeat;
}
