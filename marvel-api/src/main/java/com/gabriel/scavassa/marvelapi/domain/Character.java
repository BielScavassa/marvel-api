package com.gabriel.scavassa.marvelapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "character")
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private LocalDate modified;
	private String resourceURI;
	@ManyToMany
	@JoinTable(name="Character_Comics",
			joinColumns =@JoinColumn(name  = "character_id"),
			inverseJoinColumns = @JoinColumn(name = "comic_id"))
	private List<Comic> comics;
	@ManyToMany
	@JoinTable(name="Character_Stories",
			joinColumns =@JoinColumn(name  = "character_id"),
			inverseJoinColumns = @JoinColumn(name = "stories_id"))
	private List<Stories > stories;
//	@OneToMany
//	private List<Events> events;
//	@OneToMany
//	private List<Series> series;


}
