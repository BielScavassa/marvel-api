package com.gabriel.scavassa.marvelapi.repository;

import com.gabriel.scavassa.marvelapi.domain.Event;
import com.gabriel.scavassa.marvelapi.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Integer> {

}
