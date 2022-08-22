package com.github.javamultiplex.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Rohit Agarwal on 31/07/22 3:31 pm
 * @copyright github.com/javamultiplex
 */
@Entity
@Table(name = "authorities")
@Getter
@Setter
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;
}
