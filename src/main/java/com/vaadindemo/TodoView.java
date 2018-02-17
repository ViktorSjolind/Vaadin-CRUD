package com.vaadindemo;

import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;

public class TodoView extends Composite implements View{
	
	public TodoView(){
		setCompositionRoot(new Label("this is todo view"));
	}
	

}
