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
		
		 updateList();
		 closeEditor();
		
	}
    private void updateList() {
        grid.setItems(service.findAllFloor());
    }
	private void configureGrid() {
        grid.addClassNames("floor-grid");
        grid.setSizeFull();
        grid.setColumns("id", "name", "description","active");
       
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event -> editFloor(event.getValue()));
    }
    public void editFloor(Floor floor) {
        if (floor == null) {
            closeEditor();
        } else {
            form.setFloor(floor);
            form.setVisible(true);
            addClassName("editing");
        }
    }
    
    private void configureForm() {
        form = new FloorForm();
        form.setWidth("25em");
        form.addSaveListener(this::saveFloor); // <1>
        form.addDeleteListener(this::deleteFloor); // <2>
        form.addCloseListener(e -> closeEditor()); // <3>
    }
    private void saveFloor(FloorForm.SaveEvent event) {
        service.saveFloor(event.getFloor());
        updateList();
        closeEditor();
    }
    private void deleteFloor(FloorForm.DeleteEvent event) {
        service.deleteFloor(event.getFloor());
        updateList();
        closeEditor();
    }
    private void closeEditor() {
        form.setFloor(null);
        form.setVisible(false);
        removeClassName("editing");
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
	        btn_add_form.addClickListener(click -> addFloor());
	        return toolbar;
	}
    private void addFloor() {
        grid.asSingleSelect().clear();
        editFloor(new Floor());
    }
	
	
	

}
