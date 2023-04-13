package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.util.List;


@Data
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @Column(name="pk_genreID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pk_genreID;
    @Column(name="name")
    private String name;
    @Column(name="image")
    private String image;
    @JsonManagedReference
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "genreID", cascade = CascadeType.ALL)
    //@Column(name="pk_movieID")
    private List<Movie> movieID;

    public int getPk_genreID() {
        return pk_genreID;
    }

    public void setPk_genreID(int pk_genreID) {
        this.pk_genreID = pk_genreID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Genre() {
    }
}
