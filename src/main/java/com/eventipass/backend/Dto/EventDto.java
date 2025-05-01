package com.eventipass.backend.Dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class EventDto {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String type;
    @NotNull
    @FutureOrPresent
    private LocalDate date;
}
