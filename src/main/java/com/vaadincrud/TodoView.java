package com.vaadincrud;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


@SpringView(name = "todoView")
@Scope("prototype")	//UIScope same instance for same UI comp @Scope("prototype") for new instance for every injection
//composite more lightweight/no visual repre comp to CustomComponent
public class TodoView extends Composite implements View{		
	
	public static final String VIEW_NAME = "todoView";
	
	@Autowired
	private NoteService noteService;	
	private Grid<Note> grid;
	private VerticalLayout root;
	
	public TodoView(){
		root = new VerticalLayout();
		setCompositionRoot(root);		
		grid = new Grid<>(Note.class);		
		root.addComponent(new Label("Todo"));
		root.addComponent(grid);
		
	}
	
	@PostConstruct
	void init(){		
		List<Note> notes = noteService.findAll();
		grid.setItems(notes);		
	}

}










