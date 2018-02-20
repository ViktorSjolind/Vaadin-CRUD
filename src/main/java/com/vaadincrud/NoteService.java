package com.vaadincrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Singleton
@Service
public class NoteService {
	
	@Autowired
	NoteRepository noteRepository;
		
	public synchronized List<Note> findAll(){		
		return noteRepository.findAll();
		
	}	
	
	public synchronized Note findById(Long id){
		return noteRepository.findById(id);
	}

	public synchronized void addNote(String description) {
		Note newNote = new Note();
		newNote.setDescription(description);
		noteRepository.save(newNote);
		
	}
	
	
}
