package com.vaadincrud;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


@SpringView(name = DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View{
	
	public static final String VIEW_NAME = "";
	
	@PostConstruct	//when constructor is called bean is not yet created
	void init(){
		addComponent(new Label("this is default view"));
	}
	
	

}
