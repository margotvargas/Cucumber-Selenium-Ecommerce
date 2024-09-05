# Proyecto de Automatización de Pruebas - Tienda en Línea

Este proyecto implementa pruebas automatizadas para una tienda en línea utilizando **Selenium WebDriver** junto con **Cucumber**. El proyecto valida flujos de autenticación (login correcto y fallido), así como la navegación y validación de precios en el carrito de compras.

## Tecnologías utilizadas

- **Java**: Lenguaje principal del proyecto.
- **Selenium WebDriver**: Para automatizar la interacción con el navegador.
- **Cucumber**: Para definir los escenarios de prueba en lenguaje Gherkin.
- **JUnit**: Framework para la ejecución de pruebas unitarias.
- **Maven**: Herramienta para la gestión de dependencias y construcción del proyecto.

## Estructura del Proyecto

- **`features/`**: Contiene los archivos `.feature` que describen los escenarios de prueba.
    - `login.feature`: Pruebas de login (correcto e incorrecto).
    - `validacionPrecioCarrito.feature`: Pruebas para validar la funcionalidad de confirmar el precio del carrito de compras.

- **`steps/`**: Contiene las clases `stepsDef`, que definen los pasos para interactuar con la aplicación durante las pruebas.
    - `loginSteps.java`: Métodos para el manejo del login.
    - `homeSteps.java`: Métodos para navegar por las categorías de la tienda.
    - `carritoSteps.java`: Métodos para gestionar las acciones relacionadas con el carrito de compras.

- **`page/`**: Contiene los archivos que definen los selectores (localizadores) de elementos en la aplicación.
    - `loginPage.java`: Selectores de los elementos de la página de login.
    - `homePage.java`: Selectores de los elementos de la página principal después de iniciar sesión.
    - `carritoPage.java`: Selectores de los elementos de la página de carrito.

- **`runner/`**: Contiene la clase `RunnerTest.java` que ejecuta los escenarios definidos en Cucumber.

- **`core/`**: Contiene `DriverManager.java` para gestionar la configuración y manejo del WebDriver.

## Requisitos

Antes de ejecutar este proyecto, asegúrate de tener instalados los siguientes componentes:

- **Java 8** o superior.
- **Maven** para la gestión de dependencias.
- **ChromeDriver** para controlar el navegador Google Chrome.

## Instalación

1. Clona este repositorio:

   ```bash
   git clone https://github.com/margotvargas/Cucumber-Selenium-Ecommerce.git

2. Ve al directorio del proyecto:
   cd tu-repositorio

3. Instala las dependencias utilizando Maven:
   mvn clean install

## Configuración del WebDriver

1. Configuraciòn del WebDriver:
   Asegúrate de tener ChromeDriver instalado y ubicado en el directorio drivers/ dentro del proyecto.

## Ejecución de las pruebas
1. Para ejecutar todas las pruebas, puedes utilizar el siguiente comando:
   mvn test
2. Las pruebas se ejecutan utilizando JUnit y Cucumber. Los reportes en formato HTML y JSON se generan automáticamente en la carpeta target/cucumber.

- HTML report: target/cucumber/cucumber-report.html
- JSON report: target/cucumber/cucumber.json


## Tags de pruebas
El proyecto está configurado para ejecutar las pruebas marcadas con ciertos tags en los archivos feature.

- Para ejecutar las pruebas de regresión (validación del carrito y flujo completo), puedes utilizar el siguiente comando:

        mvn test -Dcucumber.filter.tags="@RegressionTest"

- Para ejecutar las pruebas relacionadas con errores de login:

       mvn test -Dcucumber.filter.tags="@loginfail"

- Para ejecutar las pruebas relacionadas con login correcto:

      mvn test -Dcucumber.filter.tags="@logincorrecto"


## Agradecimiento
Quisiera expresar mi más sincero agradecimiento a NTT Data por brindarnos la oportunidad de participar en el programa Tech Girl Power. Gracias a este programa, no solo he tenido la oportunidad de aprender y aplicar conocimientos en áreas de automatización de pruebas, Cucumber, Selenium, y más, sino también he crecido como profesional en tecnología. Su dedicación a la formación y empoderamiento de mujeres en la tecnología es inspiradora, y estoy muy agradecida por el apoyo y las enseñanzas que hemos recibido a lo largo de este camino.