package com.example.filmography.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "full_name")
    private String fullName;

    @NonNull
    @Column(name = "birth_date")
    private String birthDate;

    @NonNull
    private String country;

}
