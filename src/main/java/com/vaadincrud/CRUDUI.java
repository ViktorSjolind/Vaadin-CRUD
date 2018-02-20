package com.vaadincrud;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;


/*
 
 UI(viewport) associated with Page(web page) 
 VaadinSession user session with UI's open, starts when user opens UI, closes session expires on server or closed
 User Interace Components, content root layout at top
 Field component: textfield, textarea, colorpicker... 
 Data binding any field component can be bound to beans or grouped as forms
 Selection component: listselect, checkboxgroup, can be bound to SQL DB
 Component interface: field component + selection component + e.g. button
 Can only auto-wire into Spring managed beans
 
 */



@Theme("valo")
@PushStateNavigation
@SpringUI
@SpringViewDisplay
//viewdisplay gives navigator
public class CRUDUI extends UI implements ViewDisplay{	
		
	private Panel springViewDisplay;		
	@Override
	protected void init(VaadinRequest vaadinRequest){
		
		HorizontalLayout  root = new HorizontalLayout();
		root.setSizeFull();
		//sets root layout
		setContent(root);				
		root.addComponent(addNavigationBar());
		
		springViewDisplay = new Panel();
		springViewDisplay.setSizeFull();
		root.addComponent(springViewDisplay);
		root.setExpandRatio(springViewDisplay, 1.0f);
		
		
		
	}
	
	
	
	private Layout addNavigationBar(){
		CssLayout navigationBar = new CssLayout();
		navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		navigationBar.addComponent(new Label("Menu"));
		navigationBar.addComponent(createNavigationButton("Home", DefaultView.VIEW_NAME));
		navigationBar.addComponent(createNavigationButton("Todo", TodoView.VIEW_NAME));

		return navigationBar;
		
	}
	
	private Button createNavigationButton(String caption, String viewName) {
		Button button = new Button(caption);
		button.setWidth("100px");		
		button.addStyleName(ValoTheme.BUTTON_SMALL);
		button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
	    return button;
		
		
	}


	@Override
	public void showView(View view) {
		springViewDisplay.setContent((Component) view);
		
	}
	
	
}
