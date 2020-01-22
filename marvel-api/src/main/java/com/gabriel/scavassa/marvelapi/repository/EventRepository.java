package com.gabriel.scavassa.marvelapi.repository;

import com.gabriel.scavassa.marvelapi.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
