package com.vaadincrud;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = ScopedView.VIEW_NAME)
public class ScopedView extends VerticalLayout implements View{
	
	public static final String VIEW_NAME = "scopedView";
	
	@PostConstruct
	void init(){
		addComponent(new Label("scoped view from"));
	}
	
	
	
}
