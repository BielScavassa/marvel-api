package com.gabriel.scavassa.marvelapi.repository.summaries;

import com.gabriel.scavassa.marvelapi.domain.summaries.EventSumary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventSumaryRepository extends JpaRepository<EventSumary, Long> {

}
