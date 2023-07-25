package com.growkeeper.domain;

import com.growkeeper.enums.CycleOptions;
import com.growkeeper.enums.InsolationOptions;
import com.growkeeper.enums.WateringOptions;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Plant {

    @Id
    @Column(name = "plant_scientific_name", unique = true)
    private String plantScientificName;

    @Column(name = "plant_common_name")
    private String plantCommonName;

    @Column(name = "plant_edible")
    private Boolean plantEdible;

    @Column(name = "plant_watering")
    private WateringOptions plantWatering;

    @Column(name = "plant_insolation")
    private InsolationOptions plantSunlight;

    @Column(name = "plant_cycle")
    private CycleOptions plantCycle;

    @Column(name = "plant_poisonous")
    private Boolean plantPoisonous;

    @Column(name = "plant_depth")
    private Float plantDepth;

    @Column(name = "plant_diameter")
    private Float plantDiameter;
}
