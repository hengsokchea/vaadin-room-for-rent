package com.application.views.setting;

import com.application.data.entity.Floor;
import com.application.data.service.FloorService;
import com.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Floors")
@Route(value = "floors", layout = MainLayout.class)
public class FloorView extends VerticalLayout{
	
	Button btn_add_form = new Button("Add");
	Grid<Floor> grid = new Grid<>(Floor.class); 
	
	FloorService service;
	FloorForm form;

	public FloorView(FloorService service) {
		this.service = service;
		
		addClassName("floor-view");
		setSizeFull(); 
		
		configureGrid();
		configureForm();
		
		add(getToolBar(), getContent());
		
	}

	private void configureGrid() {
        grid.addClassNames("floor-grid");
        grid.setSizeFull();
        grid.setColumns("id", "name", "description","active");
       
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

       // grid.asSingleSelect().addValueChangeListener(event -> editContact(event.getValue()));
    }
	
    private void configureForm() {
        form = new FloorForm();
        form.setWidth("25em");
        //form.addSaveListener(this::saveContact); // <1>
        //form.addDeleteListener(this::deleteContact); // <2>
        //form.addCloseListener(e -> closeEditor()); // <3>
    }
    

    private HorizontalLayout getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, form);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, form);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }
    
	private HorizontalLayout getToolBar() {
		 var toolbar = new HorizontalLayout( btn_add_form); 
	        toolbar.addClassName("form_toolbar"); 
	        return toolbar;
	}
	
	
	
	

}
