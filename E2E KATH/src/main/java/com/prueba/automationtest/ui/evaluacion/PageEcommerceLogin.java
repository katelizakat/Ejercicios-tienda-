package com.prueba.automationtest.ui.evaluacion;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:webdriver.base.url.ecommerce")
public class PageEcommerceLogin extends PageObject {

    public static final Target TEXTFIELD_USER = Target.the("'Campo del usuario").locatedBy("#Email");
    public static final Target TEXTFIELD_PASSWORD = Target.the("'Campo de la contraseña'").locatedBy("#Password");
    public static final Target BUTTON_LOGIN = Target.the("'Boton Login'").locatedBy("//button[text()='Log in']");
}