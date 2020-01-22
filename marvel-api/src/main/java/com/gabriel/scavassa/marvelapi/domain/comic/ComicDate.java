package com.gabriel.scavassa.marvelapi.domain.comic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comic_date")
public class ComicDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comic_date_id")
    private Long id;
    private String type;
    private LocalDate date;
}
