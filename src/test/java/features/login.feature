Feature: Manejo de productos en el carro de compras

  Scenario: Seleccionar dos productos de la category amor para agregarlos al carro de compras
    Given home "https://www.floristeriamundoflor.com"
    When navego a la sección "Amor"
    And espero que los productos se carguen y seleccionar primer producto
    And regresar a seccion amor y seleccionar 2do producto
    Then los dos productos deberían estar en el carro de compras

  Scenario:Seleccionar un producto de la categoría cumpleaños, agregarlo y eliminarlo del carro de compras
    Given home "https://www.floristeriamundoflor.com"
    When navego a la sección cumple
    And espero que los productos se carguen y seleccionar primer producto
    And eliminar objeto
    Then no se visualizara ningun objeto en carrito




