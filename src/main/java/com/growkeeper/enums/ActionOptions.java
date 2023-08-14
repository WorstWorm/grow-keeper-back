package com.growkeeper.enums;


import lombok.Getter;

@Getter
public enum ActionOptions {

    WATER("water the plants"),
    SUN_PROTECT("protect from strong sun"),
    WIND_PROTECT("protect from strong wind"),
    COLD_PROTECT("protect against low temperatures");


    private final String option;

    ActionOptions(String option) {
        this.option = option;
    }

}
