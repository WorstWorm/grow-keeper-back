package com.growkeeper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LocationDto {

    private String locationCity;
    private String locationCountry;
    private Double locationLatitude;
    private Double locationLongitude;
}
