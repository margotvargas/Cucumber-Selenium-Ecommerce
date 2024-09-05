Feature: Login - Store

  @logincorrecto
  Scenario Outline: Validación de login en autenticación
    Given estoy en la página de la tienda
    When me logueo con mi usuario "<username>" y clave "<password>"
    Then valido que estoy autenticado correctamente

    Examples:
      | username              | password    |
      | m.vargasp@outlook.com | Prueba.2024 |


  @loginfail
  Scenario Outline: Validación de errores en autenticación
    Given estoy en la página de la tienda
    When me logueo con mi usuario "<username>" y clave "<password>"
    Then debería ver un mensaje de error de autenticacion "<mensajeError>"

    Examples:
      | username              | password     | mensajeError            |
      | m.vargasp@outlook.com | invalid_pass | Error de autenticación. |