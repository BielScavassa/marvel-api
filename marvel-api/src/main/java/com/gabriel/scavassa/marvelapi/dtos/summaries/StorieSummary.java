package com.gabriel.scavassa.marvelapi.dtos.summaries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorieSummary {
    private String ressourceURI;
    private String name;
    private String type;

}
