package com.prueba.automationtest.tasks.evaluacion;

import com.prueba.automationtest.ui.evaluacion.PageEcommerceCompra;
import com.prueba.automationtest.ui.evaluacion.PageEcommerceLogout;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

public class Logout implements Task {
    public static Logout enLaPagina() {
        return Tasks.instrumented(Logout.class);
    }

    @Step("{0} Logout:")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PageEcommerceCompra.BUTTON_LOGOUT),
                Ensure.that(PageEcommerceCompra.TEXT_SINGIN).hasTextContent("Welcome, please sign in!")
                
        );
    }
}