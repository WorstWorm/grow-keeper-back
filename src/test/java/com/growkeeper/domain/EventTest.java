package com.growkeeper.domain;


import com.growkeeper.enums.ActionOptions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventTest {

    @Test
    void eventConstructorAndGettersTest() {
        //GIVEN
        Integer id = 1;
        Integer area = 1;
        ActionOptions actionOption = ActionOptions.WATER;
        LocalDate localDate = LocalDate.of(2020,1,1);
        boolean completed = false;

        //WHEN
        Event event_shortConstructor = new Event(area, actionOption, localDate, completed);
        Event event_longConstructor = new Event(id, area, actionOption, localDate, completed);

        //THEN
        assertEquals(id, event_longConstructor.getId());
        assertEquals(area, event_longConstructor.getArea());
        assertEquals(actionOption, event_longConstructor.getActionType());
        assertEquals(localDate, event_longConstructor.getCompletionTime());
        assertEquals(completed, event_longConstructor.isCompleted());
        assertEquals(area, event_shortConstructor.getArea());
        assertEquals(actionOption, event_shortConstructor.getActionType());
        assertEquals(localDate, event_shortConstructor.getCompletionTime());
        assertEquals(completed, event_shortConstructor.isCompleted());
    }

    @Test
    void eventSettersTest() {
        //GIVEN
        Event event = new Event();

        Integer id = 1;
        Integer area = 1;
        ActionOptions actionOption = ActionOptions.WATER;
        LocalDate localDate = LocalDate.of(2020,1,1);
        boolean completed = false;

        //WHEN
        event.setId(id);
        event.setArea(area);
        event.setActionType(actionOption);
        event.setCompletionTime(localDate);
        event.setCompleted(completed);

        //THEN
        assertEquals(id, event.getId());
        assertEquals(area, event.getArea());
        assertEquals(actionOption, event.getActionType());
        assertEquals(localDate, event.getCompletionTime());
        assertEquals(completed, event.isCompleted());
    }

    @Test
    void switchCompletedTest() {
        //GIVEN
        Event event = new Event();
        event.setCompleted(false);

        //WHEN
        event.switchCompleted();

        //THEN
        assertTrue(event.isCompleted());
    }
}