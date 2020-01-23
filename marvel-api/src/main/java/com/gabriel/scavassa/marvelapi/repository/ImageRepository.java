package com.gabriel.scavassa.marvelapi.repository;

import com.gabriel.scavassa.marvelapi.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

}
