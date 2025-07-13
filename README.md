# 🧠 Backend - API de Gestión de Materiales

Este backend está construido con **Spring Boot 3.5.3**, **Java 17**, y utiliza base de datos **H2 en memoria**. Permite gestionar materiales, ciudades y departamentos de forma completa mediante API RESTful.

---

## 🚀 Requisitos Previos

- Java 17 (se recomienda Temurin)
- Maven 3.6+
- Postman (para pruebas)

---

## ⚙️ Cómo Ejecutar

1. Abre una terminal en la carpeta del backend
2. Ejecuta los comandos:

```bash
mvn clean install
mvn spring-boot:run
```

3. El backend estará disponible en:

```
http://localhost:8080
```

---

## 🌐 Endpoints disponibles

### 🧱 Materiales

- `GET /api/materiales`
- `POST /api/materiales`

### 🏙️ Ciudades

- `GET /api/ubicacion/ciudades`
- `POST /api/ubicacion/ciudades`

### 📍 Departamentos

- `GET /api/ubicacion/departamentos`
- `POST /api/ubicacion/departamentos`

> Todas las respuestas tienen este formato estándar:

```json
{
  "status": 200,
  "message": "Mensaje de éxito o error",
  "data": [...]
}
```

---

## 📚 Swagger UI

Puedes visualizar y probar todos los endpoints desde:

📄 http://localhost:8080/swagger-ui.html

---

## 🧪 Pruebas con Postman

Se incluye una colección Postman lista para importar:

📄 **Archivo**: [`postman_collection_materiales.json`](./Materiales%20API.postman_collection.json)

### ▶️ Cómo importar en Postman:

1. Abre Postman
2. Clic en **"Importar"**
3. Selecciona el archivo `postman_collection_materiales.json` ubicado en la raíz del proyecto
4. Ejecuta las peticiones por entidad: materiales, ciudades y departamentos

---

## 🗄️ Acceso a la base de datos (H2)

- URL: [`http://localhost:8080/h2-console`](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:testdb`
- Usuario: `sa`
- Contraseña: _(vacío)_

---

## 🛡️ CORS Habilitado

El backend permite llamadas desde el frontend Angular (`http://localhost:4200`) por defecto:

```java
.allowedOrigins("http://localhost:4200")
.allowedMethods("*")
```

---

## 🧩 Tecnologías

- Java 17
- Spring Boot 3.5.3
- Maven
- Swagger/OpenAPI 3
- H2 Database
- Lombok
