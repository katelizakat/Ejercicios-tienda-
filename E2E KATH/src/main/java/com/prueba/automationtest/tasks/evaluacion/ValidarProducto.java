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

public class ValidarProducto implements Task {

    private final String precio;
    private final String sku;

    public ValidarProducto(String precio, String sku) {
        this.precio = precio;
        this.sku = sku;
    }

    public static ValidarProducto conDato(String precio, String sku) {
        return instrumented(ValidarProducto.class, precio, sku);
    }

    @Step("{0} Validacion de producto")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(PageEcommerceCompra.LABEL_PRODUCTS).isDisplayed(),
                Ensure.that(PageEcommerceCompra.INPUT_PRODUCT_PRICE).hasTextContent(precio),
                Ensure.that(PageEcommerceCompra.INPUT_PRODUCT_SKU).hasTextContent(sku));
    }
}