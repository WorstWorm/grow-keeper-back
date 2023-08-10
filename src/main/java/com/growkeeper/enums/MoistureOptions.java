package com.growkeeper.enums;

import lombok.Getter;

@Getter
public enum MoistureOptions {
    WET("wet"),
    MEDIUM("medium"),
    DRY("dry");

    private final String option;

    MoistureOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

}