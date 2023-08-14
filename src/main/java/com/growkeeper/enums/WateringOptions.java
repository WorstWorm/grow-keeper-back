package com.growkeeper.enums;

import lombok.Getter;

@Getter
public enum WateringOptions {
    FREQUENT("frequent"),
    AVERAGE("average"),
    MINIMUM("minimum"),
    NONE("none");

    private final String option;

    WateringOptions(String option) {
        this.option = option;
    }

}
