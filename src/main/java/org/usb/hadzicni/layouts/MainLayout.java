package org.usb.hadzicni.layouts;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.theme.lumo.Lumo;

public class MainLayout extends AppLayout {

    public MainLayout() {
        // Toggle für das Seitenmenü
        DrawerToggle toggle = new DrawerToggle();
        addToNavbar(toggle);

        // Titel der Anwendung
        Span title = new Span("Cluster Admin Tool by Nikola Hadzic");
        title.getStyle().set("font-size", "1.5em").set("margin-left", "10px");

        HorizontalLayout navbarContent = new HorizontalLayout(title);
        navbarContent.setWidthFull();
        navbarContent.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbarContent.setAlignItems(FlexComponent.Alignment.CENTER);

        Icon darkModeIcon = VaadinIcon.MOON_O.create();
        darkModeIcon.setSize("24px");
        darkModeIcon.getStyle().set("margin-right", "16px");
        darkModeIcon.getStyle().set("cursor", "pointer");

        darkModeIcon.addClickListener(event -> toggleDarkMode());

        navbarContent.add(darkModeIcon);
        addToNavbar(navbarContent);

        addDrawerContent();
    }

    private void toggleDarkMode() {
        ThemeList themeList = getElement().getThemeList();
        if (themeList.contains(Lumo.DARK)) {
            themeList.remove(Lumo.DARK);
        } else {
            themeList.add(Lumo.DARK);
        }
    }

    private void addDrawerContent() {
        VerticalLayout sidebarContent = new VerticalLayout();
        Span text = new Span("Sidebar Content");

        Span githubLink = new Span("GitHub Repository");
        githubLink.getElement().setAttribute("style", "cursor: pointer; color: blue; text-decoration: underline;");
        githubLink.getElement().addEventListener("click", e ->
                getUI().ifPresent(ui -> ui.getPage().open("https://github.com/hadzicni/ClusterAdminTool322.git", "_blank"))
        );

        sidebarContent.add(text, githubLink);
        addToDrawer(sidebarContent);
    }

}
