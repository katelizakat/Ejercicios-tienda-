package com.prueba.automationtest.ui.evaluacion;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:webdriver.base.url.ecommerce")
public class PageEcommerceLogout extends PageObject {

    public static final Target BUTON_LOGOUT = Target.the("'Boton Logout").locatedBy("//a[@class='nav-link'][contains(.,'Logout')]");
    public static final Target LABEL_MESSAGE_WELCOME = Target.the("'Mensaje Pagina Principal'").locatedBy("(//strong[normalize-space()='Welcome, please sign in!'])[1]");
}