package com.eventtracker.service;

import com.eventtracker.dto.EventRequest;
import com.eventtracker.entity.Event;
import com.eventtracker.repository.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public void saveEvent(EventRequest request) {
        try {
            Event event = new Event();
            event.setEventName(request.getEvent());
            event.setSessionId(request.getSessionId());
            event.setPage(request.getPage());
            event.setTimestamp(LocalDateTime.now());
            event.setMetadata(mapper.writeValueAsString(request.getMetadata()));
            event.setUsername(request.getUsername());
            repository.save(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Object[]> getEventCounts() {
        return repository.countEvents();
    }
    
    public List<Event> getAllEvents() {
        return repository.findAll();
    }
}
