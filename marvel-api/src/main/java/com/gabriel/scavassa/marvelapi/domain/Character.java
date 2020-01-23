package com.gabriel.scavassa.marvelapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gabriel.scavassa.marvelapi.domain.comic.Comic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

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
	private Integer id;
	private String name;
	private String description;
	private LocalDate modified;
	private String resourceURI;
	@OneToMany
	@OrderColumn(name = "url_id")
	private Url[] url = new Url[10];
	@OneToOne
	private Image thumbnail;
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
	@ManyToMany
	@JoinTable(name="Character_Events",
			joinColumns =@JoinColumn(name  = "character_id"),
			inverseJoinColumns = @JoinColumn(name = "event_id"))
	private List<Event> events;
	@ManyToMany
	@JoinTable(name="Character_Series",
			joinColumns =@JoinColumn(name  = "character_id"),
			inverseJoinColumns = @JoinColumn(name = "series_id"))
	private List<Series> series;


}
