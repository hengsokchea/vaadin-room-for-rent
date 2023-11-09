package com.application.views.setting;

import com.application.data.entity.Room;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BeanValidationBinder;

public class RoomForm extends FormLayout {
	Binder <Room> binder=new BeanValidationBinder <>(Room.class);
	TextField name = new TextField("Room Name");
	TextField description = new TextField("Room Description");
	Checkbox actived = new Checkbox("Active");
	
	Button save = new Button("Save");
	Button delete = new Button("Delete");
	Button close = new Button("Cancel");
	public RoomForm() {
		addClassName("room-form");
		binder.bindInstanceFields(this);
		 add(new H1("Form"),name, description, actived, createButtonsLayout());
			 
	}
	public void setRoom(Room room) {
		
		binder.readBean(room);
	}
	private HorizontalLayout createButtonsLayout() {
	    save.addThemeVariants(ButtonVariant.LUMO_PRIMARY); 
	    delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
	    close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

	    save.addClickShortcut(Key.ENTER); 
	    close.addClickShortcut(Key.ESCAPE);

	    return new HorizontalLayout(save, delete, close); 
	  }
	
	//Events
	public static abstract class RoomFormEvent extends ComponentEvent <RoomForm>{
		private Room room;
		protected RoomFormEvent(RoomForm source,Room room) {
			super(source,false);
			this.room=room;
			
		}
		public Room getRoom() {
			return room;
		}
		
	}
	
}
