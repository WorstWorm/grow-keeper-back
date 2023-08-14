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
public class EventDto {

    private Integer id;
    private Integer area;
    private ActionOptions actionType;
    private LocalDate completionTime;
    private boolean completed;

    public EventDto(Integer area, ActionOptions actionType, LocalDate completionTime) {
        this.area = area;
        this.actionType = actionType;
        this.completionTime = completionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventDto event = (EventDto) o;

        if (!area.equals(event.area)) return false;
        if (actionType != event.actionType) return false;
        return completionTime.equals(event.completionTime);
    }

    @Override
    public int hashCode() {
        int result = area.hashCode();
        result = 31 * result + actionType.hashCode();
        result = 31 * result + completionTime.hashCode();
        return result;
    }
}
