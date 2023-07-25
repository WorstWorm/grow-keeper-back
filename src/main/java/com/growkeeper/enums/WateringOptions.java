package com.growkeeper.enums;

public enum WateringOptions {
    FREQUENT("frequent"),
    AVERAGE("average"),
    MINIMUM("minimum"),
    NONE("none");

    private final String option;

    WateringOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
