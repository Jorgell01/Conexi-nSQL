-- Crear la base de datos Agenda
CREATE DATABASE Agenda

-- Seleccionar la base de datos Agenda
USE Agenda

-- Crear tabla categorias
CREATE TABLE categorias (
    Categoria CHAR(4) PRIMARY KEY NOT NULL,
    Descripcion VARCHAR(50))

-- Crear tabla provincias
CREATE TABLE provincias (
    Provincia INT PRIMARY KEY NOT NULL,
    NombreProvincia VARCHAR(40))

-- Crear tabla contactos
CREATE TABLE contactos (
    Id_contacto INT PRIMARY KEY IDENTITY(1,1),
    Nombre VARCHAR(25) NOT NULL,
    Apellidos VARCHAR(50) NOT NULL,
    DNI CHAR(10),
    Telefono CHAR(9),
    Ecorreo VARCHAR(50),
    Fechacumple DATE,
    Direccion VARCHAR(50),
    Poblacion VARCHAR(50),
    Provincia INT,
    CodigoPostal CHAR(5),
    Categoria CHAR(4) NOT NULL,
    Deuda INT,
    FOREIGN KEY (Provincia) REFERENCES provincias(Provincia),
    FOREIGN KEY (Categoria) REFERENCES categorias(Categoria))

select * from categorias
select * from provincias
select * from contactos