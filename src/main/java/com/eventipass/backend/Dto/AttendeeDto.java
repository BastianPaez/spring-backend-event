package com.eventipass.backend.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter  @Setter
public class AttendeeDto {

    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @Past
    private LocalDate birthday;
    @Email
    private String email;
    @NotBlank
    private UUID eventId;
}
