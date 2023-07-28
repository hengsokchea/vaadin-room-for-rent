package com.application.views.eore;

import com.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("EORE (Trash)")
@Route(value = "eore_trash", layout = MainLayout.class)
public class EORETrashView  extends VerticalLayout{

	public EORETrashView() {
		 setSpacing(false);

	        Image img = new Image("images/empty-plant.png", "placeholder plant");
	        img.setWidth("200px");
	        add(img);

	        H2 header = new H2("This place intentionally left empty");
	        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
	        add(header);
	        add(new Paragraph("It’s a place where you can grow your own UI 🤗"));

	        setSizeFull();
	        setJustifyContentMode(JustifyContentMode.CENTER);
	        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
	        getStyle().set("text-align", "center");
	}

}
