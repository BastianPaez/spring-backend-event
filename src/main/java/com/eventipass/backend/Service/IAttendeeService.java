package com.eventipass.backend.Service;

import com.eventipass.backend.Model.Attendee;
import com.eventipass.backend.Model.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IAttendeeService {
    public void createAttendee(Attendee attendee);
    public Attendee getAttendeeById(UUID id);
    public void updateAttendee(Attendee attendee);
    public void deleteAttendeeById(UUID id);
}
