package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;

import java.util.List;

@Data
@Entity
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="pk_characterID")
    private Long pk_characterID;
    private String image;
    private String name;
    private int age;
    private double weight;
    private String story;
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "character_movies",
            joinColumns = {
                    @JoinColumn(name = "pk_characterID", nullable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "pk_movieID", nullable = false)})
    private List<Movie> movieID;

    public Character(Long pk_characterID, String image, String name, int age, double weight, String story) {
        this.pk_characterID = pk_characterID;
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.story = story;
    }

    public Character() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getStory() {
        return story;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
