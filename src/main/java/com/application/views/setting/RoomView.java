package com.application.views.setting;

import com.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;

import com.application.data.entity.*;
import com.application.data.service.RoomService;

@PageTitle("Rooms")
@Route(value = "rooms", layout = MainLayout.class)
public class RoomView extends VerticalLayout{

	TextField filterText = new TextField();
	Grid<Room> grid = new Grid<>(Room.class); 
	RoomService service;
	
	RoomForm form;
	
	public RoomView(RoomService roomService) {
		this.service=roomService;
		grid.addClassNames("room-grid"); 
        grid.setSizeFull();
        grid.setColumns("id", "name", "description","actived"); 
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(e ->editRoom(e.getValue()));
        setSizeFull(); 
        
        add(getToolbar(),getContent());
              
     
        updateList();
        closeEditor();
        
	}
	private void editRoom(Room room) {
		if(room==null) {
			closeEditor();
		}else {
			form.setRoom(room);
			form.setVisible(true);
			addClassName("editing");
		}
	}
	private void closeEditor() {
		form.setRoom(null);
		form.setVisible(false);
		removeClassName("editing");
		
	}

	private void updateList() {
		   grid.setItems(service.findAllRoom());
		
	}
	private HorizontalLayout getToolbar() {
		filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY); 

        Button btn_add_room = new Button("Add Room");
        btn_add_room.addClickListener(e ->addRoom());

        var toolbar = new HorizontalLayout(filterText, btn_add_room); 
        toolbar.addClassName("room_toolbar"); 
        return toolbar;
	}
	
	 private void addRoom() {
		grid.asSingleSelect().clear();
		editRoom(new Room());
	}
	private Component getContent() {
	        form = new RoomForm(); 
	        form.setWidth("25em");
	        
	        form.addSaveListener(this::saveRoom);
	      
	        
	        HorizontalLayout content = new HorizontalLayout(grid, form);
	        content.setFlexGrow(2, grid); 
	        content.setFlexGrow(1, form);
	        content.addClassNames("room_content");
	        content.setSizeFull();
	        return content;
	    }
	private void saveRoom(RoomForm.SaveEvent event) {
		 service.saveRoom(event.getRoom());
	        updateList();
	        closeEditor();
		
	}
	 
}

