package com.vaadincrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


@SpringView
public class TodoView extends Composite implements View{
	
	
	private NoteService noteService;
	private Grid<Note> grid;
	private VerticalLayout root;
	
	public TodoView(){
		root = new VerticalLayout();
		setCompositionRoot(root);
		
		noteService = NoteService.getInstance();
		grid = new Grid<>(Note.class);
		//List<Note> notes = noteService.findAll();
		System.out.println(noteService.findAll());
		//grid.setItems(notes);
		root.addComponent(new Label(noteService.getTest()));
		root.addComponent(grid);
		
	}
	

}










