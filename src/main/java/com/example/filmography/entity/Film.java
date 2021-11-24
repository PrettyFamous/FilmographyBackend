package com.example.filmography.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "film_name")
    private String filmName;

    @NonNull
    private String country;

    @NonNull
    @JoinColumn(name = "studio_id")
    @ManyToOne
    private Studio studio;

    @NonNull
    @JoinColumn(name = "director_id")
    @ManyToOne
    private Director director;



    public Film(String filmName, String country, Studio studio, Director director) {
        this.filmName = filmName;
        this.country = country;
        this.studio = studio;
        this.director = director;
    }
}