Feature: Product - Store

  @RegressionTestFail
  Scenario Outline: Validación de errores en autenticación y navegación
    Given estoy en la página de la tienda
    When me logueo con mi usuario "<username>" y clave "<password>"
    Then debería ver un mensaje de error de autenticacion "<mensajeError>"

    Examples:
      | username              | password     | mensajeError           |
      | m.vargasp@outlook.com | invalid_pass | Error de autenticación. |


  @RegressionTest
  Scenario Outline: Validación del precio de un producto

    Given estoy en la página de la tienda
    And me logueo con mi usuario "<username>" y clave "<password>"
    And valido que estoy autenticado correctamente
    When navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

    Examples:
      | username              | password   | categoria | subcategoria |
      | m.vargasp@outlook.com | Lucho.2012 | CLOTHES   | Men          |
      | m.vargasp@outlook.com | Lucho.2012 | AUTOS     | Men          |
