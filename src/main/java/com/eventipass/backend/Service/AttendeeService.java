package com.eventipass.backend.Service;

import com.eventipass.backend.Model.Attendee;
import com.eventipass.backend.Repository.IAttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AttendeeService implements IAttendeeService{
    @Autowired
    private IAttendeeRepository attendeeRepository;

    @Override
    public void createAttendee(Attendee attendee) {
        attendeeRepository.save(attendee);
    }


    @Override
    public Attendee getAttendeeById(UUID id) {
        return attendeeRepository.findById(id).orElse(null);
    }

    @Override
    public void updateAttendee(Attendee attendee) {
        Attendee oldAttendee = this.getAttendeeById(attendee.getId());
        if (oldAttendee == null){
            return;
        }else {
            attendeeRepository.save(attendee);
        }
    }

    @Override
    public void deleteAttendeeById(UUID id) {
        attendeeRepository.deleteById(id);
    }
}
