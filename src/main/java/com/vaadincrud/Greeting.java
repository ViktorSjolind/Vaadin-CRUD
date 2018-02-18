package com.vaadincrud;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope	//same instance for same UI comp @Scope("prototype") for new instance for every injection
public class Greeting {
	
	public String sayHello(){
		return "hello from bean" + toString();
	
	}
	
}
