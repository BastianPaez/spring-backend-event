package com.eventipass.backend.Controller;

import com.eventipass.backend.Dto.AttendeeDto;
import com.eventipass.backend.Model.Attendee;
import com.eventipass.backend.Model.Event;
import com.eventipass.backend.Service.IAttendeeService;
import com.eventipass.backend.Service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/attendee")
public class AttendeeController {
    @Autowired
    private IAttendeeService attendeeService;
    @Autowired
    private IEventService eventService;

    @PostMapping
    public ResponseEntity<String> createAttendee(@RequestBody AttendeeDto attendeeDto){

        try{
            Event event = eventService.getEventById(attendeeDto.getEventId());
            Attendee attendee = new Attendee(attendeeDto.getName(), attendeeDto.getLastName(), attendeeDto.getBirthday(), attendeeDto.getEmail(), event);
            attendeeService.createAttendee(attendee);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendee> getAttendeeById(@PathVariable UUID id){
        try {
            Attendee attendee = attendeeService.getAttendeeById(id);
            return ResponseEntity.status(HttpStatus.OK).body(attendee);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendee> updateAttendee(@RequestBody AttendeeDto attendeeUpdate, @PathVariable UUID id){
        try {
            Event event = eventService.getEventById(attendeeUpdate.getEventId());
            Attendee attendee = new Attendee(attendeeUpdate.getName(), attendeeUpdate.getLastName(), attendeeUpdate.getBirthday(), attendeeUpdate.getEmail(), event);
            attendee.setId(id);
            attendeeService.updateAttendee(attendee);
            return ResponseEntity.status(HttpStatus.OK).body(attendee);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateAttendee( @PathVariable UUID id){
        try {
            attendeeService.deleteAttendeeById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


}
