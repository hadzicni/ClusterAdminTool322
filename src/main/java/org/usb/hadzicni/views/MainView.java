package org.usb.hadzicni.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.usb.hadzicni.layouts.MainLayout;

@Route(value = "", layout = MainLayout.class)
public class MainView extends VerticalLayout {
    public MainView() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        buttonLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        for (int i = 0; i < 3; i++) {
            int vmNumber = i + 1;
            Button button = new Button("PC " + vmNumber);
            button.setWidth("200px");
            button.setHeight("200px");
            button.getStyle().set("background-color", "#F9F7F7");
            button.getStyle().set("border-radius", "15px");
            button.getStyle().set("color", "black");
            button.getStyle().set("box-shadow", "2px 2px 5px rgba(0, 0, 0, 0.3)");
            button.getStyle().set("margin", "30px");

            Dialog dialog = new Dialog();
            VerticalLayout dialogContent = new VerticalLayout();
            dialogContent.setAlignItems(Alignment.CENTER);
            dialogContent.add(new Span("Informationen zur VM " + vmNumber));
            dialogContent.add(new Span("CPU: 4 Cores"));
            dialogContent.add(new Span("RAM: 16 GB"));
            dialogContent.add(new Span("Storage: 256 GB SSD"));

            Button closeButton = new Button("Schliessen", e -> dialog.close());
            dialogContent.add(closeButton);
            dialog.add(dialogContent);

            button.addClickListener(e -> dialog.open());

            buttonLayout.add(button);
        }

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(buttonLayout);
    }
}
