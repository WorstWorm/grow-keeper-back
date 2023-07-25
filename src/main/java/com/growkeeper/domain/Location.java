package com.growkeeper.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

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
