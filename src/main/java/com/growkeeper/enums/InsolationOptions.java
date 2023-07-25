package com.growkeeper.enums;

public enum InsolationOptions {
    FULL_SHADE("full shade"),
    PART_SHADE("part shade"),
    SUN_PART_SHADE("sunny"),
    FULL_SUN("full sun");

    private final String option;

    InsolationOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}