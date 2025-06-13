package com.kiet.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.kiet.model.Volunteer;
import com.kiet.service.VolunteerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class VolunteerController {

    private final VolunteerService service;

    public VolunteerController(VolunteerService service) {
        this.service = service;
    }

    @GetMapping("/volunteers")
    public List<Volunteer> getAllVolunteers() {
        return service.retrieveAll();
    }

    @GetMapping("/volunteer/{id}")
    public Volunteer getVolunteerById(@PathVariable int id) {
        return service.retrieveById(id);
    }

    @GetMapping("/volunteers/available")
    public List<Volunteer> getAvailableVolunteers() {
        return service.retrieveAvailable();
    }

    @PostMapping("/volunteer")
    public Volunteer storeVolunteer(@RequestBody Volunteer volunteer) {
        return service.addVolunteer(volunteer);
    }

    @PutMapping("/volunteer/{id}")
    public Volunteer updateVolunteer(@PathVariable int id, @RequestBody Volunteer volunteer) {
        return service.updateVolunteer(id, volunteer);
    }

    @DeleteMapping("/volunteer/{id}")
    public void removeVolunteer(@PathVariable int id) {
        service.removeById(id);
    }
}

