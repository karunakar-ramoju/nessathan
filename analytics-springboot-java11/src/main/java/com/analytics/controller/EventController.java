package com.analytics.controller;

import com.analytics.model.Event;
import com.analytics.repo.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin
public class EventController {

    private final EventRepository repo;

    public EventController(EventRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Event save(@RequestBody Event event) {
        return repo.save(event);
    }

    @GetMapping
    public List<Event> getAll() {
        return repo.findAll();
    }
}