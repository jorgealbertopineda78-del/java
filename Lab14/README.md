# agenda-crud — CRUD de contactos (Labs 12 y 13)

| Operación | HTTP | URL | Método del Controller |
|---|---|---|---|
| Create | GET + POST | `/nuevo` + `/guardar` | `formularioNuevo` + `guardar` |
| Read | GET | `/contactos` | `listar` |
| Update | GET + POST | `/editar/{id}` + `/actualizar` | `formularioEditar` + `actualizar` |
| Delete | POST | `/eliminar/{id}` | `eliminar` |

## Ejecutar con H2 (sin instalar nada)
    ./mvnw spring-boot:run        # o: mvn spring-boot:run

Abrir http://localhost:8080/contactos

## Ejecutar con MySQL
1. `CREATE DATABASE agenda CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;`
2. Poner la contraseña en `src/main/resources/application-mysql.properties`
3. `./mvnw spring-boot:run -Dspring-boot.run.profiles=mysql`

## Capas
Controller → Service → Repository → Base de datos
