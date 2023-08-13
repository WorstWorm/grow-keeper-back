package com.growkeeper.domain;

import com.growkeeper.enums.InsolationOptions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue
    @Column(name = "area_id", unique = true)
    private Integer areaId;

    @Column(name = "area_insolation")
    private InsolationOptions areaInsolation;

    @Column(name = "covered")
    private Boolean areaCovered;

    @Column(name = "plant_scientific_name")
    private String areaScientificName;

//    public Area(Integer areaId, InsolationOptions areaInsolation, Boolean areaCovered) {
//        this.areaId = areaId;
//        this.areaInsolation = areaInsolation;
//        this.areaCovered = areaCovered;
//        this.areaScientificName = " ";
//    }
}
