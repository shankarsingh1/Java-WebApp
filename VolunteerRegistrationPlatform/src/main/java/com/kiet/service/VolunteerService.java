package com.kiet.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.kiet.model.Volunteer;
import com.kiet.repository.VolunteerRepository;

@Service
public class VolunteerService {

    private final VolunteerRepository repository;

    public VolunteerService(VolunteerRepository repository) {
        this.repository = repository;
    }

    public List<Volunteer> retrieveAll() {
        return repository.findAll();
    }

    public Volunteer retrieveById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Volunteer> retrieveAvailable() {
        return repository.findByAvailability(true);
    }

    public Volunteer addVolunteer(Volunteer volunteer) {
        return repository.save(volunteer);
    }

    public Volunteer updateVolunteer(int id, Volunteer updatedVolunteer) {
        Volunteer existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedVolunteer.getName());
            existing.setEmail(updatedVolunteer.getEmail());
            existing.setAvailability(updatedVolunteer.isAvailability());
            return repository.save(existing);
        }
        return null;
    }

    public void removeById(int id) {
        repository.deleteById(id);
    }
}

