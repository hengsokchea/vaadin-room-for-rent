package com.application.views.setting;

import com.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


import com.vaadin.flow.component.grid.Grid;
import com.application.data.entity.*;
import com.application.data.service.RoomService;

@PageTitle("Rooms")
@Route(value = "rooms", layout = MainLayout.class)
public class RoomView extends VerticalLayout{

	 Grid<Room> grid = new Grid<>(Room.class); 
	 RoomService service;
	public RoomView(RoomService roomService) {
		this.service=roomService;
		grid.addClassNames("room-grid"); 
        grid.setSizeFull();
        grid.setColumns("id", "name", "description","actived"); 
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        
        add(grid);
        setSizeFull();
        
        grid.setItems(service.findAllRoom());
        
	}

}
