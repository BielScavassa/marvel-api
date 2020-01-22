package com.gabriel.scavassa.marvelapi.repository;

import com.gabriel.scavassa.marvelapi.domain.ComicPrice;
import com.gabriel.scavassa.marvelapi.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicPriceRepository extends JpaRepository<ComicPrice, Long> {

}
