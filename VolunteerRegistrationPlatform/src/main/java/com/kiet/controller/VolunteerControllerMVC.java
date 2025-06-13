package com.kiet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.kiet.model.Volunteer;
import com.kiet.service.VolunteerService;

@Controller
public class VolunteerControllerMVC {

    private final VolunteerService service;

    public VolunteerControllerMVC(VolunteerService service) {
        this.service = service;
    }

    @GetMapping({"/volunteers", "/"})
    public String getAllVolunteers(Model model) {
        model.addAttribute("volunteers", service.retrieveAll());
        return "volunteer_index";
    }

    @GetMapping("/addVolunteer")
    public String addVolunteer(Model model) {
        model.addAttribute("volunteer", new Volunteer());
        return "volunteer_update";
    }

    @PostMapping("/saveVolunteer")
    public String insertVolunteer(@ModelAttribute Volunteer volunteer) {
        if(volunteer.getId() == 0) {
            service.addVolunteer(volunteer);
        } else {
            service.updateVolunteer(volunteer.getId(), volunteer);
        }
        return "redirect:/volunteers";
    }

    @GetMapping("/showFormUpdateVolunteer/{id}")
    public String showFormUpdateVolunteer(Model model, @PathVariable int id) {
        Volunteer volunteer = service.retrieveById(id);
        model.addAttribute("volunteer", volunteer);
        return "volunteer_update";
    }

    @GetMapping("/deleteVolunteer/{id}")
    public String deleteVolunteer(@PathVariable int id) {
        service.removeById(id);
        return "redirect:/volunteers";
    }
}
