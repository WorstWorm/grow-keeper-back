package com.growkeeper.domain;

import com.growkeeper.enums.ActionOptions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue
    @Column(name="actionId")
    private Integer id;

    @Column(name="area")
    private Integer area;

    @Column(name="action")
    @Enumerated(value = EnumType.STRING)
    private ActionOptions actionType;

    @Column(name="time")
    private LocalDate completionTime;

    @Column(name="completed")
    private boolean completed;

    public void switchCompleted() {
        completed = !completed;
    }

    public Event(Integer area, ActionOptions actionType, LocalDate completionTime, boolean completed) {
        this.area = area;
        this.actionType = actionType;
        this.completionTime = completionTime;
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

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

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", area=" + area +
                ", actionType=" + actionType +
                ", completionTime=" + completionTime +
                ", completed=" + completed +
                '}';
    }
}
