package com.eventipass.backend.Repository;

import com.eventipass.backend.Model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IAttendeeRepository extends JpaRepository<Attendee, UUID> {

}
