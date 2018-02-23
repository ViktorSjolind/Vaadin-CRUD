package com.vaadincrud;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.convert.Property;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.ButtonRenderer;


@SpringView(name = "todoView")
@Scope("prototype")	//UIScope same instance for same UI comp @Scope("prototype") for new instance for every injection
//composite more lightweight/no visual repre comp to CustomComponent
public class TodoView extends Composite implements View{		
	
	public static final String VIEW_NAME = "todoView";
	
	@Autowired
	private NoteService noteService;	
	private Grid<Note> grid;
	private VerticalLayout root;
	private VerticalLayout CRUDContainer;
	private Button addButton;
	private TextField noteTextField;
	
	public TodoView(){
		root = new VerticalLayout();
		root.setSizeFull();
		setCompositionRoot(root);				
		grid = new Grid<>(Note.class);		
		
		CRUDContainer = new VerticalLayout();
		
		Layout inputContainer = addInputContainer();
		CRUDContainer.addComponent(inputContainer);
		CRUDContainer.setComponentAlignment(inputContainer, Alignment.TOP_CENTER);
		CRUDContainer.addComponent(grid);					
		CRUDContainer.setComponentAlignment(grid, Alignment.TOP_CENTER);
		
		root.addComponent(CRUDContainer);		
		root.setComponentAlignment(CRUDContainer, Alignment.TOP_CENTER);
		
		grid.addColumn(note -> "Delete", 
				new ButtonRenderer(event -> {
					System.out.println(event.getComponent());
					System.out.println(event.getItem());
					System.out.println(grid.getSelectedItems());
					
		}));
		
		
		
		
	}
	
	private Layout addInputContainer() {
		HorizontalLayout inputLayout = new HorizontalLayout();
		
		noteTextField = new TextField();
		noteTextField.setValue("");
		
		addButton = new Button("Add Note", event -> {			
			//List of notes in Service?			
			noteService.addNote(noteTextField.getValue());
			grid.setItems(noteService.findAll());
			
		});		
		
		inputLayout.addComponent(addButton);
		inputLayout.addComponent(noteTextField);
		return inputLayout;
	}

	@PostConstruct
	void init(){		
		List<Note> notes = noteService.findAll();
		grid.setItems(notes);		
	}	
	

	
	

}










