package com.example.app.view.login;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Route("login")
@PageTitle("Логин")
@AnonymousAllowed
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    LoginForm form = new LoginForm();

    public LoginView() {
        this.addClassName("login-view");
        this.setSizeFull();

        this.setJustifyContentMode(JustifyContentMode.CENTER);
        this.setAlignItems(Alignment.CENTER);

        form.setAction("login");
        this.add(new H1("Мое приложение"), form);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent
                .getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            form.setError(true);
        }
    }
}
