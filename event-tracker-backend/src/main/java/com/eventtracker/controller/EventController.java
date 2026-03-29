package com.eventtracker.controller;

import com.eventtracker.dto.EventRequest;
import com.eventtracker.entity.Event;
import com.eventtracker.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin("*")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public String trackEvent(@RequestBody EventRequest request) {
        service.saveEvent(request);
        return "Event captured";
    }

    @GetMapping("/summary")
    public List<Object[]> getSummary() {
        return service.getEventCounts();
    }
    
    

    @GetMapping("/all-summary")
    public List<Event> getAllSummary() {
        return service.getAllEvents();
    }
    

}
