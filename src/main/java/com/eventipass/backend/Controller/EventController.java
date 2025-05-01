package com.eventipass.backend.Controller;

import com.eventipass.backend.Dto.EventDto;
import com.eventipass.backend.Model.Attendee;
import com.eventipass.backend.Model.Event;
import com.eventipass.backend.Service.IEventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class EventController {

    @Autowired
    private IEventService eventService;

    @PostMapping("/event")
    public ResponseEntity<String> createEvent(@Valid @RequestBody EventDto eventDto) {
        Event event = new Event(eventDto.getName(), eventDto.getDescription(), eventDto.getType(), eventDto.getDate());
        eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successful");
    }

    @GetMapping("/event")
    public List<Event> getAllEvent(){
        return eventService.getAllEvents();
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<Event> getEventByID(@PathVariable UUID id){
        try{
            Event event = eventService.getEventById(id);
            return ResponseEntity.status(HttpStatus.OK).body(event);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

     @PutMapping("/event/{id}")
     public ResponseEntity<Event> updateEvent(@RequestBody EventDto eventDto, @PathVariable UUID id){
         try{
             Event event = new Event(eventDto.getName(), eventDto.getDescription(), eventDto.getType(), eventDto.getDate());
             event.setId(id);
             eventService.updateEvent(event);
             return ResponseEntity.status(HttpStatus.OK).body(event);
         } catch (Exception e){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
         }
     }

    @DeleteMapping("/event/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable UUID id){
        try{
            eventService.deleteEventById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not Deleted");
        }

    }

    @GetMapping("/event/{id}/attendees")
    public List<Attendee> getAllAttendeesByEvent(@PathVariable UUID id){
        return eventService.getAllAttendeeByEvent(id);
    }

}
