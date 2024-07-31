-- Crear tabla Asegurados si no existe
CREATE TABLE IF NOT EXISTS Asegurados
(
    tipo_identificacion   INT,
    numero_identificacion INT         NOT NULL,
    apellidos             VARCHAR(50) NOT NULL,
    nombres               VARCHAR(50) NOT NULL,
    sexo                  INT         NOT NULL,
    fecha_nacimiento      DATE        NOT NULL
);

-- Insertar datos en Asegurados (sin el campo id)
INSERT INTO Asegurados (tipo_identificacion, numero_identificacion, apellidos, nombres, sexo, fecha_nacimiento)
VALUES (1, 79000001, 'APELLIDO1', 'NOMBRE1', 1, '1945-01-10'),
       (1, 79000002, 'APELLIDO2', 'NOMBRE2', 1, '1950-01-10'),
       (1, 79000003, 'APELLIDO3', 'NOMBRE3', 1, '1955-01-10'),
       (2, 51000001, 'APELLIDO4', 'NOMBRE4', 2, '1960-01-10'),
       (2, 51000002, 'APELLIDO5', 'NOMBRE5', 2, '1965-01-10'),
       (2, 51000003, 'APELLIDO6', 'NOMBRE6', 2, '1970-01-10');

-- Crear tabla Amparos si no existe
CREATE TABLE IF NOT EXISTS Amparos
(
    codigo INT,
    nombre VARCHAR(50) NOT NULL
);

-- Insertar datos en Amparos
INSERT INTO Amparos (codigo, nombre)
VALUES (1, 'Muerte accidental'),
       (2, 'Desmembración'),
       (3, 'Auxilio funerario'),
       (4, 'Renta vitalicia');

-- Crear tabla Primas si no existe
CREATE TABLE IF NOT EXISTS Primas
(
    codigo           INT,
    edad_minima      INT            NOT NULL,
    edad_maxima      INT            NOT NULL,
    porcentaje_prima DECIMAL(10, 5) NOT NULL
);

-- Insertar datos en Primas
INSERT INTO Primas (codigo, edad_minima, edad_maxima, porcentaje_prima)
VALUES (1, 18, 45, 0.02304),
       (1, 46, 75, 0.02012),
       (2, 18, 50, 0.18090),
       (2, 51, 70, 0.16043),
       (3, 18, 60, 0.14123),
       (3, 61, 70, 0.15450),
       (4, 18, 50, 0.12123),
       (4, 51, 70, 0.13450);
