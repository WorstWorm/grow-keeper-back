package com.growkeeper.dto;


import com.growkeeper.enums.ActionOptions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventDtoTest {

    @Test
    void eventDtoConstructorAndGettersTest() {
        //GIVEN
        Integer id = 1;
        Integer area = 1;
        ActionOptions actionOption = ActionOptions.WATER;
        LocalDate localDate = LocalDate.of(2020,1,1);
        boolean completed = false;

        //WHEN
        EventDto eventDto = new EventDto(id, area, actionOption, localDate, completed);

        //THEN
        assertEquals(id, eventDto.getId());
        assertEquals(area, eventDto.getArea());
        assertEquals(actionOption, eventDto.getActionType());
        assertEquals(localDate, eventDto.getCompletionTime());
        assertEquals(completed, eventDto.isCompleted());
    }

    @Test
    void eventDtoSettersTest() {
        //GIVEN
        EventDto eventDto = new EventDto();

        Integer id = 1;
        Integer area = 1;
        ActionOptions actionOption = ActionOptions.WATER;
        LocalDate localDate = LocalDate.of(2020,1,1);
        boolean completed = false;

        //WHEN
        eventDto.setId(id);
        eventDto.setArea(area);
        eventDto.setActionType(actionOption);
        eventDto.setCompletionTime(localDate);
        eventDto.setCompleted(completed);

        //THEN
        assertEquals(id, eventDto.getId());
        assertEquals(area, eventDto.getArea());
        assertEquals(actionOption, eventDto.getActionType());
        assertEquals(localDate, eventDto.getCompletionTime());
        assertEquals(completed, eventDto.isCompleted());
    }

    @Test
    void equalsTest() {
        //GIVEN
        EventDto eventDto1 = new EventDto();
        eventDto1.setArea(1);
        eventDto1.setActionType(ActionOptions.WATER);
        eventDto1.setCompletionTime(LocalDate.of(2020,1,1));

        EventDto eventDto2 = new EventDto();
        eventDto2.setArea(1);
        eventDto2.setActionType(ActionOptions.WATER);
        eventDto2.setCompletionTime(LocalDate.of(2020,1,1));

        //WHEN
        Boolean received = eventDto1.equals(eventDto2);
        Boolean expected = true;

        //THEN
        assertEquals(expected, received);
    }
}