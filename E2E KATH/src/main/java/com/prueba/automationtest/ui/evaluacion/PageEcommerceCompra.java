package com.prueba.automationtest.ui.evaluacion;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:webdriver.base.url.ecommerce")
public class PageEcommerceCompra extends PageObject {

    public static final Target MENU_CATALOGO = Target.the("'Menu Catalog")
            .locatedBy("//a[@href='#'][contains(.,'Catalog')]");
    public static final Target NAV_PRODUCTS = Target.the("'Opcion de busqueda Products'")
            .locatedBy("//a[@href='/Admin/Product/List']");
    public static final Target LABEL_PRODUCTS = Target.the("'Label Products'")
            .locatedBy("//h1[normalize-space()='Products']");
    public static final Target TEXTFIELD_SEARCH_PRODUCTS = Target.the("'Textfield Search'")
            .locatedBy("//div[@class='card card-default card-search']//div[@class='card-body']");
    public static final Target INPUT_PRODUCT_NAME = Target.the("'Input Product Name'")
            .locatedBy("//input[@id='SearchProductName']");
    public static final Target BUTTON_SEARCH = Target.the("'Boton Search'").locatedBy("#search-products");
    public static final Target BUTTON_EDIT = Target.the("'Boton Editar'").locatedBy("//a[text()='Edit']");
    public static final Target LABEL_EDIT_PRODUCT_DETAILS = Target.the("'Label Edit Product Details'")
            .locatedBy("//h1[contains(text(), 'Edit product details - Lenovo IdeaCentre 600 All-in-One PC')]");
    public static final Target INPUT_PRICE = Target.the("'Input Price'")
            .locatedBy("//div[@id='product-price-area']//descendant::input[1]");

    public static final Target BUTTON_SAVE = Target.the("'Boton Save'").located(By.name("save"));
    public static final Target LABEL_EDITAR_EXITOSO = Target.the("'Label Edicion exitosa'")
            .locatedBy("//div[@class='alert alert-success alert-dismissable']");

    public static final Target INPUT_PRODUCT_PRICE = Target.the("'Input Product Price'")
            .locatedBy("//*[@id=\"products-grid\"]/tbody/tr/td[5]");
    public static final Target INPUT_PRODUCT_SKU = Target.the("'Input Product SKU'")
            .locatedBy("//*[@id=\"products-grid\"]/tbody/tr/td[4]");

    public static final Target BUTTON_LOGOUT = Target.the("'Boton Logout'")
            .locatedBy("//*[@id=\"navbarText\"]/ul/li[3]/a");

    public static final Target TEXT_SINGIN = Target.the("'Textfield Sing In'")
            .locatedBy("//div[@class='title']");

}