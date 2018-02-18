package com.vaadincrud;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


@SpringView(name = "todoView")
public class TodoView extends Composite implements View{
	
	@Autowired
	private NoteService noteService;
	
	private Grid<Note> grid;
	private VerticalLayout root;
	
	public TodoView(){
		root = new VerticalLayout();
		setCompositionRoot(root);		
		noteService = NoteService.getInstance();
		
		
		
	}
	
	@PostConstruct
	void init(){
		grid = new Grid<>(Note.class);
		List<Note> notes = noteService.findAll();
		grid.setItems(notes);
		
		root.addComponent(new Label(noteService.getString()));
		root.addComponent(grid);
	}

}










