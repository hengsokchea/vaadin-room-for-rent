package com.application.views;

import com.application.views.about.AboutView;
import com.application.views.daily_activity.DailyActivityErrorView;
import com.application.views.daily_activity.DailyActivityTobeApproveView;
import com.application.views.daily_activity.DailyActivityTrashView;
import com.application.views.dashboard.DashboardView;
import com.application.views.eod.EODErrorView;
import com.application.views.eod.EODTBApproveView;
import com.application.views.eod.EODTrashView;
import com.application.views.eore.EOREErrorView;
import com.application.views.eore.EORETBApproveView;
import com.application.views.eore.EORETrashView;
import com.application.views.helloworld.HelloWorldView;
import com.application.views.setting.PermissionView;
import com.application.views.setting.RoomView;
import com.application.views.setting.UserView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.shared.Tooltip;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("GO-IMS External Tool");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        SideNavItem dailyActivitySection = new SideNavItem("Daily Activity");
        dailyActivitySection.setPrefixComponent(VaadinIcon.RECORDS.create());       
        
        dailyActivitySection.addItem(new SideNavItem("Daily Activity (Check/Approve)", DailyActivityTobeApproveView.class, VaadinIcon.CHECK_CIRCLE .create()));
        dailyActivitySection.addItem(new SideNavItem("Daily Activity (Error)",  DailyActivityErrorView.class, VaadinIcon.CLOSE.create()));
        dailyActivitySection.addItem(new SideNavItem("Daily Activity (Trash)", DailyActivityTrashView.class, VaadinIcon.TRASH.create()));
        
        SideNavItem eoreSection = new SideNavItem("EORE");
        eoreSection.setPrefixComponent(VaadinIcon.RECORDS.create());
        eoreSection.addItem(new SideNavItem("EORE (Approve)", EORETBApproveView.class, VaadinIcon.CHECK_CIRCLE .create()));
        eoreSection.addItem(new SideNavItem("EORE (Error)", EOREErrorView.class, VaadinIcon.CLOSE.create()));
        eoreSection.addItem(new SideNavItem("EORE (Trash))", EORETrashView.class, VaadinIcon.TRASH.create()));
        
        SideNavItem eodSection = new SideNavItem("EOD");
        eodSection.setPrefixComponent(VaadinIcon.RECORDS.create());
        eodSection.addItem(new SideNavItem("EOD (Approve)", EODTBApproveView.class, VaadinIcon.CHECK_CIRCLE .create()));
        eodSection.addItem(new SideNavItem("EOD (Error)", EODErrorView.class, VaadinIcon.CLOSE.create()));
        eodSection.addItem(new SideNavItem("EOD (Trash))", EODTrashView.class, VaadinIcon.TRASH.create()));
        
        
        
        SideNavItem settingSection = new SideNavItem("Setting");
        settingSection.setPrefixComponent(VaadinIcon.COG.create());
        settingSection.addItem(new SideNavItem("Users", UserView.class, VaadinIcon.GROUP.create()));
        settingSection.addItem(new SideNavItem("Permissions", PermissionView.class, VaadinIcon.KEY.create()));
        settingSection.addItem(new SideNavItem("Rooms", RoomView.class, VaadinIcon.KEY.create()));
        
        
        nav.addItem(new SideNavItem("Dashboard", DashboardView.class, VaadinIcon.DASHBOARD.create()));
        
        nav.addItem(dailyActivitySection);
        nav.addItem(eoreSection);
        nav.addItem(eodSection);
        nav.addItem(settingSection);
        nav.addItem(new SideNavItem("About", AboutView.class, LineAwesomeIcon.FILE.create()));
        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
