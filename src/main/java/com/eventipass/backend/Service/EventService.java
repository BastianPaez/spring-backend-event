package com.eventipass.backend.Service;

import com.eventipass.backend.Model.Attendee;
import com.eventipass.backend.Model.Event;
import com.eventipass.backend.Repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService implements IEventService{
    @Autowired
    private IEventRepository eventRepository;

    @Override
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Attendee> getAllAttendeeByEvent(UUID id) {
        Optional<Event> event = eventRepository.findById(id);
        if(event.isEmpty()){
            return new ArrayList<>();
        }else {
            return event.get().getAttendeeList();
        }
    }

    @Override
    public Event getEventById(UUID id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public void updateEvent(Event event) {
        Event oldEvent = this.getEventById(event.getId());
        if(oldEvent == null){
            return;
        }else {
            eventRepository.save(event);
        }
    }

    @Override
    public void deleteEventById(UUID id) {
        eventRepository.deleteById(id);
    }
}
