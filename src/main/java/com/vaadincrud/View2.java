package com.vaadincrud;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;


@SpringView(name = "vew2")
public class View2 extends Composite implements View{
	
	public View2(){
		setCompositionRoot(new Label("this is view 2"));
	}
	

}
