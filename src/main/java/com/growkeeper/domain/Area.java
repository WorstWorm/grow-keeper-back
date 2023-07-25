package com.growkeeper.domain;

import com.growkeeper.enums.InsolationOptions;
import com.growkeeper.enums.MoistureOptions;
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

    @Column(name = "area_moisture")
    private MoistureOptions areaMoisture;

    @Column(name = "area_insolation")
    private InsolationOptions areaInsolation;

    @Column(name = "area_length")
    private Float areaLength;

    @Column(name = "area_width")
    private Float areaWidth;

    @Column(name = "area_depth")
    private Float areaDepth;

    @Column(name = "plant_scientific_name")
    private String areaScientificName;
}
