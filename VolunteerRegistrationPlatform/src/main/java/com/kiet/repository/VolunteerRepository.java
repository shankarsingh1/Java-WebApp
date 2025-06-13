package com.kiet.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kiet.model.Volunteer;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {
    List<Volunteer> findByAvailability(boolean availability);
}
