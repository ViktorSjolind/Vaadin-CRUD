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
public class TodoUI extends UI{	
	
	
	
	@Override
	protected void init(VaadinRequest vaadinRequest){		
		Label title = new Label("Menu");
		title.addStyleName(ValoTheme.MENU_TITLE);
		
		Button button1 = new Button("View 1", e->getNavigator().navigateTo("view1"));
		button1.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
		Button button2 = new Button("View 2", e->getNavigator().navigateTo("view2"));
		button2.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
		
		//renders components and their captions into a same div element
		CssLayout menu = new CssLayout(title, button1, button2);
		menu.addStyleName(ValoTheme.MENU_ROOT);
		
		CssLayout viewContainer = new CssLayout();
		HorizontalLayout mainLayout = new HorizontalLayout(menu, viewContainer);
		mainLayout.setSizeFull();
		setContent(mainLayout);
		
		//UI, container which will be replaced
		Navigator navigator = new Navigator(this, viewContainer);		
		//bad practice? How to set a default view?
		navigator.addView("", View1.class);
		navigator.addView("view1", View1.class);
		navigator.addView("view2", View2.class);
		
		
		
		
	}
	
}
