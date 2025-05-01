package com.eventipass.backend.Service;

import com.eventipass.backend.Model.Attendee;
import com.eventipass.backend.Model.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IEventService {

    public void createEvent(Event event);
    public List<Event> getAllEvents();
    public List<Attendee> getAllAttendeeByEvent(UUID id);
    public Event getEventById(UUID id);
    public void updateEvent(Event event);
    public void deleteEventById(UUID id);


}
