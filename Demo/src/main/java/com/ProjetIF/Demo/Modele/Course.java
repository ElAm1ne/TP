package com.ProjetIF.Demo.Modele;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "course")
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
}
