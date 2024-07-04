package com.prueba.automationtest.tasks.evaluacion;

import com.prueba.automationtest.ui.evaluacion.PageEcommerceCompra;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarProducto implements Task {

    private final String producto;

    public BuscarProducto(String producto) {
        this.producto = producto;
    }

    public static BuscarProducto conDato(String producto) {
        return instrumented(BuscarProducto.class, producto);
    }

    @Step("{0} Buqueda de producto")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!PageEcommerceCompra.NAV_PRODUCTS.waitingForNoMoreThan(Duration.ofSeconds(2)).isVisibleFor(actor)){
            actor.attemptsTo(
                    Click.on(PageEcommerceCompra.MENU_CATALOGO),
                    Click.on(PageEcommerceCompra.NAV_PRODUCTS)
            );
        }
        if (!PageEcommerceCompra.INPUT_PRODUCT_NAME.waitingForNoMoreThan(Duration.ofSeconds(2)).isVisibleFor(actor)){
            actor.attemptsTo(
                    Click.on(PageEcommerceCompra.TEXTFIELD_SEARCH_PRODUCTS)
            );
        }
        actor.attemptsTo(
                Ensure.that(PageEcommerceCompra.LABEL_PRODUCTS).isDisplayed(),
                Enter.theValue(producto).into(PageEcommerceCompra.INPUT_PRODUCT_NAME),
                Click.on(PageEcommerceCompra.BUTTON_SEARCH)
        );

    }
}