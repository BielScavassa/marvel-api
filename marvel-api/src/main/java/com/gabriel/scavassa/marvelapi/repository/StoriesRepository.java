package com.gabriel.scavassa.marvelapi.repository;

import com.gabriel.scavassa.marvelapi.domain.Stories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoriesRepository extends JpaRepository<Stories, Integer> {

}
