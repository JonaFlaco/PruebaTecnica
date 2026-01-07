# Prueba Técnica - Sistema de Gestión de Productos

Sistema completo de gestión de productos desarrollado con Spring Boot (backend) y Vue.js 3 (frontend).
## Tabla de Contenidos

- [Descripción](#descripción)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Requisitos Previos](#requisitos-previos)
- [Instalación](#instalación)
- [Configuración](#configuración)
- [Ejecución](#ejecución)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [API Endpoints](#api-endpoints)

## Descripción

POroyecto para prueba tecnica

### Funcionalidades Principales

- ✅ Crear nuevos productos
- ✅ Listar todos los productos
- ✅ Interfaz de usuario intuitiva y responsiva

## 🛠 Tecnologías Utilizadas

### Backend (`pt-backend`)

- **Java 21** - Lenguaje de programación
- **Spring Boot 4.0.1** - Framework de aplicación
- **Spring Data JPA** - Persistencia de datos
- **PostgreSQL** - Base de datos relacional
- **Lombok** - Reducción de código boilerplate
- **Gradle** - Gestor de dependencias y construcción

### Frontend (`pt-frontend`)

- **Vue.js 3** - Framework JavaScript progresivo
- **TypeScript** - Tipado estático para JavaScript
- **Vue Router 4** - Enrutamiento de la aplicación
- **Axios** - Cliente HTTP para peticiones API
- **Vue CLI 5** - Herramientas de desarrollo
- **ESLint + Prettier** - Linting y formateo de código
- **Estilos** - Realizado con IA ChatGPT

## Requisitos

Antes de comenzar, asegúrate de tener instalado:

- **Java 21** o superior
- **Node.js** (versión 14 o superior) y **npm**
- **PostgreSQL** (versión 12 o superior)
- **Gradle**

## 🔧 Instalación

### 1. Clonar el Repositorio

### 2. Configurar la Base de Datos

1. Crea una base de datos en PostgreSQL con el nombre 'pt'

2. PostgreSQL debe estar ejecutandose en el puerto `5432`.

### 3. Instalar Dependencias del Backend

Instalar Gradle

### 4. Instalar Dependencias del Frontend

npm i
npm i axios (en caso de ser necesario)
npm i vue-router@4 (en caso de ser necesario)

## Configuración

### Backend

Edita el archivo `application.properties` para ajustar la configuración de la base de datos si es necesario:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pt
spring.datasource.username=postgres
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
```

### Frontend

El frontend está configurado para conectarse al backend en `http://localhost:8081`.


## Ejecución

### Backend (Encender primero)

1. Navega a la carpeta del backend:

2. Abrir visual exclusivamente para el backend

3. Dar click en la extension de Gradle

4. Abrir la carpeta Task

5. Abrir la carpeta application

6. Iniciar la aplicacion con el BootRun

### FrontEnd (Encender segundo)

1. Ejecutar en la terminal el comando 'npm run serve'


## Estructura del Proyecto

```
Entrevista/
├── pt-backend/                    # Aplicación Spring Boot
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/jonathan/pt_backend/
│   │   │   │       ├── config/           # Configuración (CORS, etc.)
│   │   │   │       ├── controller/       # Controladores REST
│   │   │   │       ├── dto/              # Data Transfer Objects
│   │   │   │       ├── entity/           # Entidades JPA
│   │   │   │       ├── exception/        # Manejo de excepciones
│   │   │   │       ├── mapper/           # Mappers (Entity ↔ DTO)
│   │   │   │       ├── repository/       # Repositorios JPA
│   │   │   │       └── service/           # Lógica de negocio
│   │   │   └── resources/
│   │   │       └── application.properties # Configuración
│   │   └── test/                  # Tests
│   ├── build.gradle               # Dependencias Gradle
│   └── gradlew                    # Gradle Wrapper
│
└── pt-frontend/                   # Aplicación Vue.js
    ├── src/
    │   ├── components/            # Componentes Vue reutilizables
    │   ├── interface/             # Interfaces TypeScript
    │   ├── router/                # Configuración de rutas
    │   ├── services/              # Servicios API (Axios)
    │   ├── views/                 # Vistas/páginas
    │   ├── App.vue                # Componente raíz
    │   └── main.ts                # Punto de entrada
    ├── package.json               # Dependencias npm
    └── vue.config.js              # Configuración Vue CLI
```

## API Endpoints

### Base URL
```
http://localhost:8080/api/products
```

### Endpoints Disponibles

#### 1. Crear Producto
- **Método:** `POST`
- **URL:** `/api/products`
- **Body:**
```json
{
  "name": "Nombre del producto",
  "price": 99.99,
  "stock": 100
}
```
- **Respuesta:** `201 Created` con el producto creado

#### 2. Obtener Todos los Productos
- **Método:** `GET`
- **URL:** `/api/products`
- **Respuesta:** `200 OK` con lista de productos

#### 3. Obtener Producto por ID
- **Método:** `GET`
- **URL:** `/api/products/{id}`
- **Respuesta:** `200 OK` con el producto solicitado

### Modelo de Datos

#### Product (Entidad)
```json
{
  "id": 1,
  "name": "Producto Ejemplo",
  "price": 99.99,
  "stock": 100,
  "createdAt": "2024-01-01T10:00:00"
}
```