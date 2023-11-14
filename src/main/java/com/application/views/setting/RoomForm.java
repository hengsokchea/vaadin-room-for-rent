package com.application.views.setting;

import com.application.data.entity.Room;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
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
import com.vaadin.flow.shared.Registration;
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
		
		binder.setBean(room);
	}
	private HorizontalLayout createButtonsLayout() {
	    save.addThemeVariants(ButtonVariant.LUMO_PRIMARY); 
	    delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
	    close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

	    save.addClickShortcut(Key.ENTER); 
	    close.addClickShortcut(Key.ESCAPE);
	    
	    save.addClickListener(event -> validateAndSave()); // <1>
	    delete.addClickListener(event -> fireEvent(new DeleteEvent(this, binder.getBean()))); // <2>
	    close.addClickListener(event -> fireEvent(new CloseEvent(this))); // <3>
	    
	    binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid())); // <4>

	    return new HorizontalLayout(save, delete, close); 
	  }
	 private void validateAndSave() {
		    if(binder.isValid()) {
		      fireEvent(new SaveEvent(this, binder.getBean())); // <6>
		    }
		  }
	 
	
	public Registration addSaveListener(ComponentEventListener<SaveEvent> listener) {
		    return addListener(SaveEvent.class, listener);
	}
	public Registration addDeleteListener(ComponentEventListener<DeleteEvent> listener) {
		    return addListener(DeleteEvent.class, listener);
	}
	  public Registration addCloseListener(ComponentEventListener<CloseEvent> listener) {
		    return addListener(CloseEvent.class, listener);
	 }
	
	 public static class SaveEvent extends RoomFormEvent {
		    SaveEvent(RoomForm source, Room room) {
		      super(source, room);
		    }
	} 
	 
	 public static class DeleteEvent extends RoomFormEvent {
		    DeleteEvent(RoomForm source, Room room) {
		      super(source, room);
		    }

	}
	 
	  public static class CloseEvent extends RoomFormEvent {
		    CloseEvent(RoomForm source) {
		      super(source, null);
		    }
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
