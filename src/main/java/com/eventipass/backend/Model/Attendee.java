package com.eventipass.backend.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter @Setter
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String lastName;
    private LocalDate birthday;
    private String email;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Attendee() {
    }

    public Attendee(String name, String lastName, LocalDate birthday, String email, Event event) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.event = event;
    }
}
