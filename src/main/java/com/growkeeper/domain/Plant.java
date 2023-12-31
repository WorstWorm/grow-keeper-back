package com.growkeeper.domain;

import com.growkeeper.enums.InsolationOptions;
import com.growkeeper.enums.WateringOptions;
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
@Table(name = "plant")
public class Plant {

    @Id
    @Column(name = "plant_scientific_name", unique = true)
    private String plantScientificName;

    @Column(name = "plant_common_name")
    private String plantCommonName;

    @Column(name = "plant_watering")
    @Enumerated(value = EnumType.STRING)
    private WateringOptions plantWatering;

    @Column(name = "plant_insolation")
    @Enumerated(value = EnumType.STRING)
    private InsolationOptions plantSunlight;
}
