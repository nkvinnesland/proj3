package com.example.application.views.myview;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import ai.peoplecode.OpenAIConversation;


@PageTitle("My View")
@Menu(icon = "line-awesome/svg/pencil-ruler-solid.svg", order = 0)
@Route("")
public class MyViewView extends Composite<VerticalLayout> {
    private OpenAIConversation conversation;
    private TextField textField;
    private Paragraph textLarge;

    class MyClickListener implements ComponentEventListener<ClickEvent<Button>> {

        @Override
        public void onComponentEvent(ClickEvent<Button> event) {
            String reply = conversation.askQuestion("Your are non-partisan", textField.getValue());
            textLarge.setText(reply);
        }
    }

    public MyViewView() {

        conversation = new OpenAIConversation(apiKey, "gpt-4o-mini");
        H1 h1 = new H1();
        H4 h4 = new H4();
        Button buttonPrimary = new Button();
        Button buttonPrimary2 = new Button();
        Button buttonPrimary3 = new Button();
        Paragraph textLarge = new Paragraph();
        TextField textField = new TextField();
        Button buttonPrimary4 = new Button();

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");

        h1.setText("Welcome to NP-AI");
        h1.setWidth("max-content");

        h4.setText(
                "Please select a topic below to get an objective AI summary. You can also ask follow up questions you may have.");
        h4.setWidth("max-content");

        buttonPrimary.setText("Climate Change");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonPrimary2.setText("Israeli/Palestine Conflict");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary2);
        buttonPrimary2.setWidth("min-content");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonPrimary3.setText("Moon Landing Faked?");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary3);
        buttonPrimary3.setWidth("min-content");
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

//        textLarge.setText("Standing by....");
//        textLarge.setWidth("100%");
//        textLarge.getStyle().set("font-size", "var(--lumo-font-size-xl)");
        textLarge = new Paragraph();
        textLarge.setWidth("80%");
        textLarge.setHeight("300px");
        textLarge.getStyle().set("border", "1px solid black");

        textField.setLabel("Ask a Question");
        textField.setWidth("min-content");

        buttonPrimary4.setText("Ask");
        buttonPrimary4.setWidth("min-content");
        buttonPrimary4.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        getContent().add(h1);
        getContent().add(h4);
        getContent().add(buttonPrimary);
        getContent().add(buttonPrimary2);
        getContent().add(buttonPrimary3);
        getContent().add(textLarge);
        getContent().add(textField);
        getContent().add(buttonPrimary4);

        buttonPrimary4.addClickListener(new MyClickListener());
    }
}
