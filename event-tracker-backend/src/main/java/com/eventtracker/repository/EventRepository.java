package com.eventtracker.repository;

import com.eventtracker.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e.eventName, COUNT(e) FROM Event e GROUP BY e.eventName")
    List<Object[]> countEvents();
}
