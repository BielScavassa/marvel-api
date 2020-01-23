package com.gabriel.scavassa.marvelapi.repository.comic;

import com.gabriel.scavassa.marvelapi.domain.comic.TextObjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextObjectsRepository extends JpaRepository<TextObjects, Integer> {

}
