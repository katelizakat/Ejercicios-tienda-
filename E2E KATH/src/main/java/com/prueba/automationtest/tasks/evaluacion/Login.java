package com.prueba.automationtest.tasks.evaluacion;

import com.prueba.automationtest.ui.evaluacion.PageEcommerceLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;


public class Login implements Task {

    private final String user;
    private final String pass;

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public static Login conCredenciales(String user, String pass) {
        return Tasks.instrumented(Login.class, user, pass);
    }

    @Step("{0} inicia sesión:")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Task.where("Ingresa las credenciales e inicia sesión",
                        Enter.theValue(this.user).into(PageEcommerceLogin.TEXTFIELD_USER),
                        Enter.theValue(this.pass).into(PageEcommerceLogin.TEXTFIELD_PASSWORD),
                        Click.on(PageEcommerceLogin.BUTTON_LOGIN)
                )
        );
    }
}