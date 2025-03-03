package com.app.todoapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity  // marks this class as a table in todo-app schema(database)
@Data  // shortcut annotation for @Getter (on all fields) @Setter (on all non-final fields)
public class Task {
	
	@Id  // marks primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String title;
	private boolean completed;

}
