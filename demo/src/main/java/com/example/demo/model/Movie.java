package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Column(name="pk_movieID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long pk_movieID;
    @Column(name="name")
    private String name;
    @JsonFormat(pattern="yyyy/MM/dd")
    @Column(name="releaseDate")
    private Date releaseDate;
    private double rating;
    @JsonBackReference
    @ManyToMany(fetch=FetchType.LAZY, mappedBy = "movieID", cascade = CascadeType.ALL)
    private List<Character> characterID;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="pk_genreID")
    private Genre genreID;

    public Movie(Long pk_movieID, String name, Date releaseDate, double rating) {
        this.pk_movieID = pk_movieID;
        this.name = name;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public Long getPk_movieID() {
        return pk_movieID;
    }

    public void setPk_movieID(Long pk_movieID) {
        this.pk_movieID = pk_movieID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Movie() {
    }
}
