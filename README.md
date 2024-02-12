# Controlador de productos REST


Para solucionar este ejercicio, creé un controlador REST que administra las operaciones relacionadas con los productos. Este controlador ofrece un punto de acceso para ordenar productos según criterios específicos. Además, opté por agregar una columna llamada "categoria" en el modelo de producto para una solución escalable. También he creado una clase llamada SortingCriteria para definir los criterios de ordenamiento (ventas por unidades, ratio de stock), lo que nos proporcionará más modularidad y reutilización en el futuro.

He optado por crear una lista de productos para la prueba en lugar de utilizar una tabla de productos en la base de datos.
## Descripción

El controlador `ProductController` ofrece la funcionalidad de ordenar productos en base a criterios de clasificación proporcionados por el cliente. Utiliza un servicio `ProductService` para realizar la lógica de ordenación y devolver la lista de productos ordenada.

## Endpoints

- `POST /products/sort`: Permite ordenar los productos en base a criterios específicos.
    - Parámetros de solicitud:
        - `category`: La categoría de productos sobre la que se realizará la ordenación.
        - `sortingCriteria`: Los criterios de ordenación, como unidades vendidas, ratio de stock, etc.
    - Cuerpo de la solicitud:
      ```json
      {
          "salesUnitsWeight": 0.8,
          "stockRatioWeight": 0.2
      }
      ```
    - Respuesta: Una lista de productos ordenada según los criterios proporcionados.

## Ejemplo de uso

Para ordenar los productos de la categoría "T-Shirts" en base a las unidades vendidas y al ratio de stock:

- Método: `POST`
- URL: `http://localhost:8080/products/sort?category=T-Shirts`
- Cuerpo de la solicitud:
  ```json
  {
      "salesUnitsWeight": 0.8,
      "stockRatioWeight": 0.2
  }

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.2.2
- Maven

## Ejecución de la prueba

he creado dos classes de prueba, una a nivel http/endPoint, otra para probar la funcionalidad interna
- ProductControllerIntegrationTest.java
- ProductServiceTest.java
## Autor

  Farouk Arroub
