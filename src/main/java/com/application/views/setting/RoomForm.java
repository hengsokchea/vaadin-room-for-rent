package com.application.views.setting;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class RoomForm extends FormLayout {
	TextField txtname = new TextField("Room Name");
	TextField txtdescription = new TextField("Room Description");
	Checkbox txtactive = new Checkbox("Active");
	
	Button save = new Button("Save");
	Button delete = new Button("Delete");
	Button close = new Button("Cancel");
	public RoomForm() {
		addClassName("room-form");
		
		 add(new H1("Form"),txtname, txtdescription, txtactive, createButtonsLayout());
			 
	}
	private HorizontalLayout createButtonsLayout() {
	    save.addThemeVariants(ButtonVariant.LUMO_PRIMARY); 
	    delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
	    close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

	    save.addClickShortcut(Key.ENTER); 
	    close.addClickShortcut(Key.ESCAPE);

	    return new HorizontalLayout(save, delete, close); 
	  }
	
}
