package com.vaadincrud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html

public interface NoteRepository extends JpaRepository<Note, Long>{
	
		
	Note findById(Long id);
	List<Note> findAll();
	
}



























