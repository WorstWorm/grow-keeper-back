package com.growkeeper.enums;

public enum CycleOptions {
    PERENNIAL("perennial"),
    ANNUAL("annual"),
    BIENNIAL("biennial"),
    BIANNUAL("biannual");

    private final String option;

    CycleOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
