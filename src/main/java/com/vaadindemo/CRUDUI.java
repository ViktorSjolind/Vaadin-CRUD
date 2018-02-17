package com.vaadindemo;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;


/*
 
 UI(viewport) associated with Page(web page) 
 VaadinSession user session with UI's open, starts when user opens UI, closes session expires on server or closed
 User Interace Components, content root layout at top
 Field component: textfield, textarea, colorpicker... 
 Data binding any field component can be bound to beans or grouped as forms
 Selection component: listselect, checkboxgroup, can be bound to SQL DB
 
 
 
 */


@SpringUI
@Theme("valo")
@PushStateNavigation
public class CRUDUI extends UI{	
	
	private Navigator navigator;
	private HorizontalLayout mainLayout;
	private CssLayout viewContainer;	
	private CssLayout menuContainer;
	
	@Override
	protected void init(VaadinRequest vaadinRequest){
		
		viewContainer = new CssLayout();
		addMenu();		
		mainLayout = new HorizontalLayout(menuContainer, viewContainer);
		mainLayout.setSizeFull();			
		setContent(mainLayout);		
		setupNavigator();
		
	}
	
	private void addMenu() {
		Label title = new Label("Menu");
		title.addStyleName(ValoTheme.MENU_TITLE);
		
		Button buttonTodo = new Button("Todo", e->getNavigator().navigateTo("viewTodo"));
		buttonTodo.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
		
		Button button2 = new Button("View 2", e->getNavigator().navigateTo("view2"));
		button2.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
		
		//renders components and their captions into a same div element
		menuContainer = new CssLayout(title, buttonTodo, button2);
		menuContainer.addStyleName(ValoTheme.MENU_ROOT);
		
	}

	private void setupNavigator(){
		//UI, container which will be replaced
		navigator = new Navigator(this, viewContainer);		
		//bad practice? How to set a default view?
		navigator.addView("", TodoView.class);
		navigator.addView("viewTodo", TodoView.class);
		navigator.addView("view2", View2.class);
	}
	
	
}
