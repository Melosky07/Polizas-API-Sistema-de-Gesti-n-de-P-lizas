Descripción del Proyecto

Este proyecto implementa un backend REST que permite administrar pólizas y sus riesgos asociados. Está diseñado siguiendo buenas prácticas de arquitectura backend, separación por capas y uso de JPA para persistencia.

La API permite:

Crear pólizas
Consultar pólizas existentes
Renovar pólizas
Gestionar riesgos asociados

Tecnologías Utilizadas

Java 17+
Spring Boot
Spring Data JPA
Maven
MySQL / H2 Database
REST API
JSON

Estructura del Proyecto
src/main/java/com/polizas/polizas_api
│
├── controller     # Endpoints REST
├── service        # Lógica de negocio
├── repository     # Acceso a datos (JPA)
├── model          # Entidades
└── PolizasApiApplication.java
⚙️ Requisitos Previos


Antes de ejecutar el proyecto debes tener instalado:
Java JDK 17 o superior
Maven
Visual Studio Code o IntelliJ IDEA
MySQL (opcional si usas H2)

Verificar instalación:
java -version
mvn -v


Configuración del Proyecto
1️.Clonar el repositorio
git clone (https://github.com/Melosky07/Polizas-API-Sistema-de-Gesti-n-de-P-lizas.git)
cd polizas-api
2️.Configurar Base de Datos
Editar el archivo:
src/main/resources/application.properties

Ejemplo MySQL:
spring.datasource.url=jdbc:mysql://localhost:3306/polizas_db
spring.datasource.username=root
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Ejecutar la Aplicación

Desde VS Code o terminal:

mvn spring-boot:run

La API iniciará en:

http://localhost:8080
Endpoints Principales
Crear póliza: POST /polizas
Consultar pólizas: GET /polizas
Renovar póliza: POST /polizas/{id}/renovar

Pruebas con Postman

Abrir Postman

Crear request POST

URL:

http://localhost:8080/polizas

Body (JSON):

{
  "numero": "POL-001",
  "cliente": "Juan Perez"
}

Arquitectura

El proyecto sigue una arquitectura en capas:
Controller → Maneja solicitudes HTTP
Service → Contiene la lógica del negocio
Repository → Persistencia con JPA
Model → Entidades de base de datos

Flujo de Renovación de Póliza

Se consulta la póliza existente.
Se valida su estado.
Se crea una nueva póliza basada en la anterior.
Se actualizan los riesgos asociados.

👨‍💻 Autor

Sebastián David Melo Díaz
Ingeniero de Sistemas
