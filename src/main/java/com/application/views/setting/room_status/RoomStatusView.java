package com.application.views.setting.room_status;

import com.application.data.entity.Room;
import com.application.data.entity.RoomStatus;
import com.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


@PageTitle("Room Status")
@Route(value = "setting/room_status", layout = MainLayout.class)

public class RoomStatusView extends VerticalLayout{
	

	Grid<RoomStatus> grid = new Grid<>(RoomStatus.class); 
	Button btnAdd=new   Button("Add item",new Icon(VaadinIcon.PLUS));
	

	
	TextField txtquick_search=new TextField();
	Button btn_remove_quick_search=new   Button("Clear filters",new Icon(VaadinIcon.BAN));
	Button btn_apply_quick_search=new   Button("Filter results",new Icon(VaadinIcon.FILTER));
	Button btn_export=new   Button("Export",new Icon(VaadinIcon.ARROW_CIRCLE_DOWN));
	
	public  RoomStatusView() {
		addClassName("room-status-view");
		setSizeFull(); 
		
		HorizontalLayout toolBar=new HorizontalLayout();
		
		
		HorizontalLayout toolBar_left=new HorizontalLayout();
		toolBar_left.add(txtquick_search,btn_apply_quick_search,btn_remove_quick_search,btn_export);
		//toolBar_left.setAlignItems(Alignment.END);
		
		btnAdd.setIconAfterText(true);
		btn_apply_quick_search.setIconAfterText(true);
		btn_remove_quick_search.setIconAfterText(true);
		txtquick_search.setPlaceholder("Quick Search");
		
	
		toolBar.add(btnAdd,toolBar_left);
		//toolBar.add(new LayoutItem( btnAdd));
		
	
		
		grid.addClassNames("room-status-grid");
	    grid.setSizeFull();
	    grid.setColumns("id", "name", "description","active");
	    grid.getColumns().forEach(col -> col.setAutoWidth(true));

	        
		add(toolBar,grid);
	}

}
