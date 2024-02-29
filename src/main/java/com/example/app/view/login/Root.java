package com.example.app.view.login;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@Route("")
@RolesAllowed({"USER", "ADMIN"})
public class Root extends VerticalLayout {

    public Root() {
        this.add(new H1("Контент пользователя"));
    }
}
