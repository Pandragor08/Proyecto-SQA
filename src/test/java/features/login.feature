Feature: Funcionalidad de inicio de sesión


  Scenario: Abrir página web
    Given La usuario está en la página de inicio de sesión "https://opensource-demo.orangehrmlive.com"
    When La usuario introduce credenciales válidas
    Then El usuario debe ser redirigido a la página de inicio.
    And Debería mostrarse un mensaje de bienvenida
