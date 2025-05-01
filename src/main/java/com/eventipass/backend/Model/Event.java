package com.eventipass.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;
    private String type;
    private LocalDate date;

    @OneToMany(mappedBy = "event")
    @JsonIgnore
    private List<Attendee> attendeeList;

    public Event(){

    }

    public Event( String name, String description, String type, LocalDate date) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.date = date;
    }


}
