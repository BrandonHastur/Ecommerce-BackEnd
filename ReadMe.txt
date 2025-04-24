# E-Commerce - Backend CRUD con Microservicios

Este proyecto representa el backend de un sistema e-commerce desarrollado bajo una arquitectura de microservicios utilizando Java y Spring Boot. Se han implementado operaciones CRUD para las principales entidades del sistema, con una estructura modular y escalable.

## Descripción del proyecto

El sistema está compuesto por los siguientes microservicios:

- **Producto Service**
- **Cliente Service**
- **Pedido Service**

Cada uno de estos servicios cuenta con su propia base de datos, lógica de negocio, y estructura de paquetes bien definida. Además, comparten clases comunes a través de un módulo `commons`.

## Arquitectura y estructura del proyecto

Cada microservicio está organizado en capas, siguiendo buenas prácticas de diseño:

- `controllers`: Controladores REST que exponen los endpoints.
- `services`: Contiene la lógica de negocio.
- `repositories`: Interfaces que acceden a la base de datos usando Spring Data JPA.
- `dto`: Clases de transferencia de datos.
- `mappers`: Conversores entre entidades y DTOs.
- `clients`: Uso de **Feign Client** para la comunicación entre microservicios.

### Características funcionales

- CRUD completo para las entidades **Producto**, **Cliente** y **Pedido**.
- La eliminación de **Pedidos** es una **baja lógica**, no se elimina físicamente el registro.
- La eliminación de un **Cliente** con pedidos asociados realiza una **eliminación en cascada** para mantener la integridad de datos.
- Uso de **Feign Clients** para la comunicación entre servicios.
- Implementación de un **API Gateway** como punto de entrada único para los microservicios.
- Debe Ejecutar eureka server, Gateway y los 3 Microservicios

## Configuración del entorno

Se utilizó **Oracle Database** como motor principal de persistencia.

Las configuraciones de conexión a la base de datos (URL, usuario y contraseña) se manejan mediante **variables de entorno** en el archivo `application.properties` de cada microservicio. Ejemplo:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

Tecnologías utilizadas
- Java

-Spring Boot

-Spring Cloud(Eureka, Gateway, OpenFeign)

-Spring Data JPA

-Feign Client

-Oracle Database

-API Gateway (Spring Cloud Gateway)

-Maven 

Estructura típica de un microservicio
producto-service/
├── src/main/java/com/ecommerce/producto/
│   ├── clients/
│   ├── controllers/
│   ├── dto/
│   ├── mappers/
│   ├── repositories/
│   └── services/
└── src/main/resources/
    └── application.properties


Documentacion de las apis 

https://documenter.getpostman.com/view/41488991/2sB2izCsTb

Link del repositorio remoto
