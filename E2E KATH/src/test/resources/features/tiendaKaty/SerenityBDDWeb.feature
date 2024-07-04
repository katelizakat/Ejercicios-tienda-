@REQ_PQBP-511 @SerenityBDDWeb @R2 @Agente2
Feature:  Pruebas para automatizacion WEB desde SerenityBDD
  Varios scenarios de pruebas Web con SerenityBDD


  @id:4 @CompraTelefono @CompraTelefonoExitosa123
  Scenario Outline: T-E2E-PQBP-511-CA04 - Compra de productos tecnologicos.
    Para realizar una compra exitosa de un producto  como cliente sin realizar login en la aplicación  necesito ser capaz de realizar y verificar la compra
    Given que el cliente ingresa a la pagina de demoblaze para seleccionar el "<producto>" y el "<producto2>"
    When el decide hacer la compra ingresa sus datos personales "<name>", "<country>", "<city>", "<card>", "<month>" y "<year>"
    Then el realiza la compra del producto exitosamente
    Examples:
      | @externaldata@demo/dataTiendaKaty.csv |

