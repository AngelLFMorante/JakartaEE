# 📌 Proyecto Base para Entrevistas Técnicas con Jakarta EE, JAX-RS y Hibernate

Este es un proyecto base diseñado para entrevistas técnicas, proporcionando una estructura sencilla pero funcional con Jakarta EE, JAX-RS (API REST), Hibernate con JPA y EJB.

📜 **Licencia**: MIT - Cualquiera puede hacer fork o contribuir para mejorarlo.

## 🚀 Tecnologías Utilizadas

- **Jakarta EE 10** (incluyendo JAX-RS para la API REST)
- **Hibernate JPA** para la persistencia de datos
- **EJB** (Enterprise Java Beans) para la capa de servicio
- **WildFly** como servidor de aplicaciones
- **Docker** para facilitar el despliegue
- **H2 Database** (en memoria, para pruebas rápidas)

---

## 📂 Estructura del Proyecto

```
    📦 myapp
     ┣ 📂 src/main/java/org/afernandez/example/jakarta
     ┃ ┣ 📂 entity       # Entidades JPA (Producto)
     ┃ ┣ 📂 service      # Lógica de negocio con EJB (ProductoService)
     ┃ ┣ 📂 rest         # Recursos JAX-RS (ProductoResource)
     ┃ ┗ 📂 config       # Configuración de JAX-RS (JAXRSConfiguration)
     ┣ 📂 src/main/resources/META-INF
     ┃ ┗ persistence.xml # Configuración de la unidad de persistencia
     ┣ 📂 src/main/webapp/WEB-INF
     ┃ ┗ web.xml         # Configuración del despliegue web
     ┣ Dockerfile        # Configuración para desplegar con Docker
     ┣ pom.xml           # Configuración de Maven y dependencias
     ┗ README.md         # Este archivo 📖
```

---

## 🔥 Cómo Levantar el Proyecto con Docker

### 1️⃣ Compilar el proyecto con Maven

```sh
  mvn clean package
```

### 2️⃣ Construir la imagen Docker

```sh
  docker build -t myapp .
```

### 3️⃣ Ejecutar el contenedor Docker

```sh
  docker run -p 8080:8080 -p 9990:9990 myapp
```

---

## 📡 Endpoints REST y Ejemplos con `curl`

### 🔍 Obtener todos los productos
```sh
  curl -X GET http://localhost:8080/api/productos -H "Accept: application/json"
```

### ➕ Crear un producto
```sh
  curl -X POST http://localhost:8080/api/productos \
     -H "Content-Type: application/json" \
     -d '{"nombre": "Monitor", "precio": 199.99}'
```

### ❌ Eliminar un producto por ID
```sh
  curl -X DELETE http://localhost:8080/api/productos/1
```

---

## 🎤 Preguntas de Entrevista y Respuestas

### 1️⃣ ¿Qué es Jakarta EE y en qué se diferencia de Java EE?
**Respuesta:** Jakarta EE es la evolución de Java EE, ahora bajo la Fundación Eclipse. Ofrece mejoras en modularidad, uso de CDI y actualizaciones en APIs como JAX-RS.

### 2️⃣ ¿Cómo funciona JAX-RS en este proyecto?
**Respuesta:** JAX-RS se usa para exponer recursos REST. `ProductoResource` define endpoints como `@GET`, `@POST` y `@DELETE`, gestionando solicitudes HTTP.

### 3️⃣ ¿Qué rol juega Hibernate JPA?
**Respuesta:** Hibernate JPA es la implementación de JPA utilizada aquí. Maneja la persistencia de datos en `ProductoService` con `EntityManager`.

### 4️⃣ ¿Por qué usamos EJB en este proyecto?
**Respuesta:** EJB permite manejar la lógica de negocio con transacciones automáticas. `ProductoService` es un `@Stateless` EJB para garantizar una gestión eficiente.

### 5️⃣ ¿Cómo configuraste Docker para desplegar el proyecto?
**Respuesta:** Se usa un `Dockerfile` que extiende WildFly, copia el WAR generado y lo despliega. Luego, el contenedor expone los puertos 8080 y 9990.

---

📢 **Contribuye**: Siéntete libre de hacer un **fork** y mejorar el proyecto. ¡Toda contribución es bienvenida! 😊

