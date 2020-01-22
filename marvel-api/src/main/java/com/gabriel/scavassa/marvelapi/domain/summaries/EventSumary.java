package com.gabriel.scavassa.marvelapi.domain.summaries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event_sumary")
public class EventSumary {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_sumary_id")
    private Long id;
    private String resourceURI;
    private String name;
}
