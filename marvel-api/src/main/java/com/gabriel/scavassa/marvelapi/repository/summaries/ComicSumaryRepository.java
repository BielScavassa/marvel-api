package com.gabriel.scavassa.marvelapi.repository.summaries;

import com.gabriel.scavassa.marvelapi.domain.summaries.ComicSumary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicSumaryRepository extends JpaRepository<ComicSumary, Integer> {

}
