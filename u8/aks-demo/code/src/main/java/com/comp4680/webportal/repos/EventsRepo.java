package com.comp4680.webportal.repos;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.comp4680.webportal.models.Events;

public interface EventsRepo extends JpaRepository<Events, Integer> {
    @Query("select e from Events e where e.id != :id and e.code = :code")
    List<Events> findEventsWithSameCode(@Param("id") int id, @Param("code") String code);

    // Add a query method to find an event by its id and the status is E
    @Query("select e from Events e where e.id = :id and e.status = 'E'")
    Optional<Events> isEventsEnded(@Param("id") int id);
}