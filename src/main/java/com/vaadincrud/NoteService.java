package com.vaadincrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Singleton
@Service
public class NoteService {
	
	@Autowired
	NoteRepository noteRepository;

	private static NoteService instance;	
	
	public NoteService(){
		
	}	
	
	public static NoteService getInstance(){		
		if(instance == null){
			instance = new NoteService();			
		}
		return instance;
	}
	
	public synchronized List<Note> findAll(){		
		return noteRepository.findAll();
		
	}
	
	public String getTest(){
		return "hueheuheuheUEHUWHEUWHEUH";
	}
	
	public synchronized Note findById(Long id){
		return noteRepository.findById(id);
	}
	
}
