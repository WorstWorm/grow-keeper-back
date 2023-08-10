package com.growkeeper.dto;

import com.growkeeper.enums.ActionOptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ActionDto {
    private ActionOptions actionType;
    private LocalDate completionTime;
}
