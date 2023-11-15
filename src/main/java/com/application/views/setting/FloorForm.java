package com.application.views.setting;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.checkbox.Checkbox;

import com.application.data.entity.Floor;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;

public class FloorForm extends FormLayout {
	TextField name = new TextField("Floor Name"); 
	TextField description = new TextField("Description");
	Checkbox active = new Checkbox("Is Active");
	
	Button save = new Button("Save");
	Button delete = new Button("Delete");
	Button close = new Button("Cancel");
	
	Binder<Floor> binder = new BeanValidationBinder<>(Floor.class);

	public FloorForm() {
		addClassName("floor-form");
		binder.bindInstanceFields(this);
		
		add(name, description,active, createButtonsLayout());
	}

	private Component createButtonsLayout() {
		 save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		 delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
		 close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		 
		 save.addClickShortcut(Key.ENTER);
		 close.addClickShortcut(Key.ESCAPE);
		 
		 save.addClickListener(event -> validateAndSave()); // <1>
		 
		 return new HorizontalLayout(save, delete, close);
	}
	public void setFloor(Floor floor) {
		    binder.setBean(floor); // <1>
	}
	private void validateAndSave() {
		 if(binder.isValid()) {
			 fireEvent(new SaveEvent(this, binder.getBean())); // <6>
		 }
	}
	public static class SaveEvent extends FloorFormEvent {
	    SaveEvent(FloorForm source, Floor floor) {
	      super(source, floor);
	    }
	}
	
	// Events
	  public static abstract class FloorFormEvent extends ComponentEvent<FloorForm> {
	    private Floor floor;

	    protected FloorFormEvent(FloorForm source, Floor floor) {
	      super(source, false);
	      this.floor = floor;
	    }

	    public Floor getFloor() {
	      return floor;
	    }
	  }
	  
	 public Registration addSaveListener(ComponentEventListener<SaveEvent> listener) {
		    return addListener(SaveEvent.class, listener);
	}
	
}
