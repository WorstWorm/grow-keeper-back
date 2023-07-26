package com.growkeeper.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Location {

    @Id
    @Column(name = "city", unique = true)
    private String locationCity;

    @Column(name = "country")
    private String locationCountry;

    @Column(name = "latitude")
    private Double locationLatitude;

    @Column(name = "longitude")
    private Double locationLongitude;
}
