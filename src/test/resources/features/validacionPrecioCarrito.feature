Feature: Product - Store

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
      | username              | password    | categoria | subcategoria |
      | m.vargasp@outlook.com | Prueba.2024 | CLOTHES   | Men          |
      | m.vargasp@outlook.com | Prueba.2024 | AUTOS     | Men          |


    ##Nota:
    ##La segunda prueba falla ya que no existe la categoria AUTOS
