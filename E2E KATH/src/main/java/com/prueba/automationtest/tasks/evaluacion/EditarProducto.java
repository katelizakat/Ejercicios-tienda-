package com.prueba.automationtest.tasks.evaluacion;

import com.prueba.automationtest.model.evaluacion.Edicion;
import com.prueba.automationtest.ui.evaluacion.PageEcommerceCompra;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.time.Duration;

public class EditarProducto implements Task {

    private final Edicion edicion;

    public EditarProducto(Edicion edicion) {
        this.edicion = edicion;
    }

    public static EditarProducto conInformacion(Edicion edicion) {
        return instrumented(EditarProducto.class, edicion);
    }

    @Step("{0} Edita los datos del producto")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PageEcommerceCompra.BUTTON_EDIT),
                Ensure.that(PageEcommerceCompra.LABEL_EDIT_PRODUCT_DETAILS).isDisplayed(),
                //Se realiza acciones por teclado Ctrl + A y se elimina el contenido del input para ingresar el valor correspondiente
                Enter.keyValues(Keys.CONTROL,Keys.chord("a"),Keys.DELETE,edicion.getPrecio()).into(PageEcommerceCompra.INPUT_PRICE),
                Click.on(PageEcommerceCompra.BUTTON_SAVE),
                Ensure.that(PageEcommerceCompra.LABEL_EDITAR_EXITOSO.waitingForNoMoreThan(Duration.ofSeconds(2))).isDisplayed()
        );
    }
}