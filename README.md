# Prueba Técnica Linktic 🚀

Este documento proporciona instrucciones detalladas para clonar, configurar y ejecutar el proyecto en un entorno local,
utilizando Docker y Docker Compose. Además, se incluye la configuración de Swagger para la documentación de la API.

## Clonar el Proyecto 📥

Para comenzar, clona el repositorio del proyecto utilizando el siguiente comando:

```bash
git clone https://github.com/NICORUIZ93/Spring-Boot-Linktic.git
cd prueba-tecnica-linktic
```

## Configuración de la Base de Datos 🗄️

Es necesario tener PostgreSQL instalado y configurado. Una vez listo, utiliza el siguiente script SQL para crear las
tablas necesarias en la base de datos.

### Creación de Tablas 📊

```sql
-- Tabla Asegurados
CREATE TABLE Asegurados
(
    tipo_identificacion   INT,
    numero_identificacion VARCHAR(10),
    apellidos             VARCHAR(50),
    nombres               VARCHAR(50),
    sexo                  INT,
    fecha_nacimiento      DATE
);

-- Tabla Amparos
CREATE TABLE Amparos
(
    codigo INT,
    nombre VARCHAR(50)
);

-- Tabla Primas
CREATE TABLE Primas
(
    codigo           INT,
    edad_minima      INT,
    edad_maxima      INT,
    porcentaje_prima DECIMAL(5, 4)
);
```

### Inserción de Datos 📝

Después de crear las tablas, inserta los datos de ejemplo:

```sql
INSERT INTO Asegurados (tipo_identificacion, numero_identificacion, apellidos, nombres, sexo, fecha_nacimiento)
VALUES (1, '79000001', 'APELLIDO1', 'NOMBRE1', 1, TO_DATE('1945-01-10', 'YYYY-MM-DD')),
       (1, '79000002', 'APELLIDO2', 'NOMBRE2', 1, TO_DATE('1950-01-10', 'YYYY-MM-DD')),
       (1, '79000003', 'APELLIDO3', 'NOMBRE3', 1, TO_DATE('1955-01-10', 'YYYY-MM-DD')),
       (2, '51000001', 'APELLIDO4', 'NOMBRE4', 2, TO_DATE('1960-01-10', 'YYYY-MM-DD')),
       (2, '51000002', 'APELLIDO5', 'NOMBRE5', 2, TO_DATE('1965-01-10', 'YYYY-MM-DD')),
       (2, '51000003', 'APELLIDO6', 'NOMBRE6', 2, TO_DATE('1970-01-10', 'YYYY-MM-DD'));

INSERT INTO Amparos (codigo, nombre)
VALUES (1, 'Muerte accidental'),
       (2, 'Desmembración'),
       (3, 'Auxilio funerario'),
       (4, 'Renta vitalicia');

INSERT INTO Primas (codigo, edad_minima, edad_maxima, porcentaje_prima)
VALUES (1, 18, 45, 0.02304),
       (1, 46, 75, 0.02012),
       (2, 18, 50, 0.18090),
       (2, 51, 70, 0.16043),
       (3, 18, 60, 0.14123),
       (3, 61, 70, 0.15450),
       (4, 18, 50, 0.12123),
       (4, 51, 70, 0.13450);
```

## Ejecución con Docker y Docker Compose 🐳

Para construir y ejecutar los contenedores de Docker, asegúrate de tener Docker y Docker Compose instalados. Luego,
ejecuta el siguiente comando en la raíz del proyecto:

```bash
docker-compose up --build
```

Detener los Contenedores

```bash
docker-compose down
```

## Acceder a la Aplicación

Una vez los contenedores estén en ejecución, la aplicación estará disponible en:

[http://localhost:8080](http://localhost:8080)

## Documentación de la API 📖

### Swagger

La documentación de la API está disponible a través de Swagger. Puedes acceder a la interfaz de Swagger en:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Postman

Para facilitar las pruebas de la API, se proporcionará una colección de Postman.

Puedes importar la colección en Postman
utilizando el enlace proporcionado en la documentación del proyecto.

[Linktic API](https://documenter.getpostman.com/view/11742617/2sA3kd9cNd)


