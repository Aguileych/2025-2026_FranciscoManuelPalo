# Minesweeper

---

| | |
|---|---|
| **Ciclo Formativo** | Desarrollo de Aplicaciones Web (DAW) |
| **Centro Educativo** | I.E.S. Suárez de Figueroa |
| **Autor/a** | Francisco Manuel Palo Rubio |
| **Tutor/a** | José Andrés Paredes Arribas  |
| **Fecha de presentación** | Junio 2026 |
| **Repositorio** | [github.com/suarezfigueroa/2025-2026_FranciscoManuelPalo](https://github.com/suarezfigueroa/2025-2026_FranciscoManuelPalo) |

---

## Índice

1. [Introducción](#1-introducción)
2. [Objetivos del proyecto](#2-objetivos-del-proyecto)
3. [Justificación del proyecto](#3-justificación-del-proyecto)
   - 3.1 [Análisis de mercado](#31-análisis-de-mercado)
   - 3.2 [Vinculación con contenidos del Ciclo Formativo](#32-vinculación-con-contenidos-del-ciclo-formativo)
4. [Recursos utilizados](#4-recursos-utilizados)
   - 4.1 [Entornos de desarrollo](#41-entornos-de-desarrollo)
   - 4.2 [Lenguajes de programación](#42-lenguajes-de-programación)
   - 4.3 [Utilidades](#43-utilidades)
5. [Tecnologías de desarrollo](#5-tecnologías-de-desarrollo)
6. [Diseño del proyecto](#6-diseño-del-proyecto)
   - 6.1 [Diseño de la base de datos](#61-diseño-de-la-base-de-datos)
   - 6.2 [Carga de datos inicial](#62-carga-de-datos-inicial)
   - 6.3 [Diseño de la interfaz de usuario](#63-diseño-de-la-interfaz-de-usuario)
   - 6.4 [Roles de la aplicación](#64-roles-de-la-aplicación)
   - 6.5 [Usuarios creados para pruebas](#65-usuarios-creados-para-pruebas)
7. [Lógica y codificación del proyecto](#7-lógica-y-codificación-del-proyecto)
   - 7.1 [Principales procesos](#71-principales-procesos)
   - 7.2 [Aspectos relevantes de la implementación](#72-aspectos-relevantes-de-la-implementación)
8. [Despliegue web del proyecto](#8-despliegue-web-del-proyecto)
9. [Manual de usuario](#9-manual-de-usuario)
10. [Conclusiones y aspectos a mejorar](#10-conclusiones-y-aspectos-a-mejorar)
11. [Bibliografía](#11-bibliografía)
- [Anexo I — Script SQL de la base de datos](#anexo-i--script-sql-de-la-base-de-datos)
- [Anexo II — Diseño prototipo en Lunacy](#anexo-ii--diseño-prototipo-en-lunacy)
- [Anexo III — Script SQL de datos de prueba](#anexo-iii--script-sql-de-datos-de-prueba)

---

## 1. Introducción

**Minesweeper** es una aplicación web basada en el juego clásico del Buscaminas. El proyecto no se limita a una simple reimplementación del juego: incorpora un sistema de usuarios registrados con ranking global, logros desbloqueables, puntos canjeables por temas estéticos y soporte multiidioma (español e inglés), todo ello accesible desde el navegador sin necesidad de instalación.

El backend está desarrollado en Java con Spring Boot, exponiendo una API REST que es consumida por el frontend, compuesto por páginas HTML con CSS y JavaScript vanilla. La persistencia de datos se gestiona mediante MariaDB.

---

## 2. Objetivos del proyecto

- Desarrollar una versión web jugable del clásico juego Buscaminas con tres niveles de dificultad: Fácil, Normal y Difícil.
- Implementar un sistema de autenticación y registro de usuarios.
- Crear un ranking global de jugadores registrados visible para todos los visitantes.
- Diseñar un sistema de logros que recompense al jugador con puntos según sus partidas.
- Permitir que los puntos obtenidos se canjeen por temas estéticos para personalizar la interfaz.
- Ofrecer al usuario registrado un historial de partidas y ajustes de cuenta (cambio de nombre, contraseña y eliminación de cuenta).
- Implementar un cambio de idioma dinámico (español / inglés) sin recargar la página, disponible para cualquier visitante.
- Aplicar buenas prácticas de desarrollo web: arquitectura REST, seguridad con Spring Security, y separación clara entre frontend y backend.

---

## 3. Justificación del proyecto

### 3.1 Análisis de mercado

El Buscaminas es uno de los juegos de lógica más reconocidos a nivel mundial, popularizado por su inclusión en los sistemas operativos Windows durante décadas. Sin embargo, las versiones web actuales del juego se limitan en su mayoría a ofrecer únicamente la mecánica de juego básica, sin ningún tipo de sistema de progresión, personalización ni comunidad.

Plataformas como [minesweeper.online](https://minesweeper.online) ofrecen una versión web del juego con ranking, pero con una interfaz poco cuidada y sin opciones de personalización estética. Otras implementaciones son simples ejercicios de JavaScript sin backend ni persistencia de datos.

Este proyecto cubre esa necesidad: una aplicación web completa que combina la jugabilidad clásica del Buscaminas con un sistema de progresión (logros y puntos), personalización visual (temas) y una experiencia de usuario cuidada, todo construido con tecnologías modernas del ciclo DAW.

### 3.2 Vinculación con contenidos del Ciclo Formativo

El proyecto integra de forma directa los contenidos trabajados a lo largo del Ciclo Formativo de Desarrollo de Aplicaciones Web:

- **Programación**: toda los conocimientos base y lenguaje java.
- **Desarrollo web en entorno cliente**: toda la lógica del juego, la gestión dinámica de la interfaz y las llamadas a la API REST se realizan con JavaScript vanilla, aplicando los conocimientos del módulo de desarrollo en entorno cliente.
- **Desarrollo web en entorno servidor**: aplicación de arquitectura REST y JPA para el acceso a datos.
- **Bases de datos**: diseño, implementación y gestión de la base de datos relacional con MariaDB, incluyendo relaciones entre entidades y consultas JPA.
- **Diseño de interfaces web**: la interfaz de usuario ha sido diseñada con HTML y CSS, prestando atención a la usabilidad, accesibilidad, con soporte para múltiples temas visuales.
- **Despliegue de aplicaciones web**: configuración del entorno de ejecución con Spring Boot embebido.

---

## 4. Recursos utilizados

### 4.1 Entornos de desarrollo

| Herramienta | Uso |
|---|---|
| [Visual Studio Code](https://code.visualstudio.com/) | IDE principal para el desarrollo del frontend (HTML, CSS, JavaScript) y del backend (Java / Spring Boot) |
| [HeidiSQL](https://www.heidisql.com/) | Cliente gráfico para la gestión y consulta de la base de datos MariaDB |
| [Lunacy](https://icons8.com/lunacy) | Herramienta de diseño de interfaz y prototipado de pantallas |

### 4.2 Lenguajes de programación

| Lenguaje | Parte de la aplicación | Finalidad |
|---|---|---|
| **Java 21** | Backend | Lógica de negocio, controladores REST, entidades JPA y seguridad |
| **HTML5** | Frontend | Estructura de todas las páginas de la aplicación |
| **CSS3** | Frontend | Estilos visuales, temas estéticos intercambiables y diseño responsivo |
| **JavaScript (ES6+)** | Frontend | Lógica del juego Buscaminas, llamadas fetch a la API REST, cambio de idioma dinámico y manipulación del DOM |
| **SQL** | Base de datos | Definición del esquema (DDL) y carga de datos iniciales (DML) |

### 4.3 Utilidades

| Recurso | Descripción | URL |
|---|---|---|
| **Maven** | Gestor de dependencias y construcción del proyecto Java | [maven.apache.org](https://maven.apache.org/) |
| **MariaDB** | Sistema gestor de base de datos relacional | [mariadb.org](https://mariadb.org/) |
| **Spring Boot 4.0.6** | Framework base del backend | [spring.io/projects/spring-boot](https://spring.io/projects/spring-boot) |
| **Spring Security** | Módulo de autenticación y control de acceso | [spring.io/projects/spring-security](https://spring.io/projects/spring-security) |
| **Spring Data JPA** | Acceso y mapeo objeto-relacional con la base de datos | Incluido en Spring Boot |
| **MariaDB Java Client** | Conector JDBC para MariaDB | [mariadb.com/kb/en/about-mariadb-connector-j](https://mariadb.com/kb/en/about-mariadb-connector-j/) |

---

## 5. Tecnologías de desarrollo

### REST API

La arquitectura de la aplicación sigue el patrón **REST** (Representational State Transfer). El backend expone endpoints HTTP que el frontend consume mediante `fetch`. Esta separación permite que la interfaz sea completamente independiente del servidor, facilitando el mantenimiento y la escalabilidad. Se eligió REST frente a otras alternativas como GraphQL por su simplicidad y por ser el estándar más utilizado en el entorno laboral actual.

### Spring Boot

Spring Boot es un framework de Java que simplifica la creación de aplicaciones web y APIs REST, eliminando gran parte de la configuración manual que requería Spring Framework tradicional. Permite levantar un servidor embebido (Tomcat) y arrancar la aplicación como un ejecutable `.jar`. Se eligió por su amplia adopción en el mercado, su ecosistema maduro y porque es una de las tecnologías más demandadas en el perfil de desarrollador web backend con Java.

### Spring Security

Módulo de Spring que gestiona la autenticación y autorización de la aplicación. Permite proteger los endpoints de la API de forma declarativa, gestionando sesiones, contraseñas cifradas con BCrypt y control de acceso por roles. Se eligió frente a implementaciones manuales de seguridad por su robustez y su integración nativa con Spring Boot.

### Spring Data JPA / Hibernate

Spring Data JPA abstrae el acceso a la base de datos mediante el patrón repositorio, generando automáticamente las consultas SQL a partir de las entidades Java anotadas con JPA. Hibernate actúa como implementación del proveedor JPA. Esta tecnología evita escribir SQL manualmente para las operaciones CRUD, reduciendo el código y los errores.

### MariaDB

Sistema gestor de base de datos relacional de código abierto, compatible con MySQL. Se eligió por su estabilidad, rendimiento, coste cero y por ser el SGBD utilizado durante el ciclo formativo. La versión empleada es la 12.2.2.

### HTML5 / CSS3 / JavaScript

El frontend está construido con tecnologías web estándar sin frameworks adicionales. JavaScript se usa en su versión ES6+ con la API `fetch` nativa para las llamadas al backend. Esta decisión se tomó para consolidar los conocimientos fundamentales del desarrollo web en entorno cliente sin depender de librerías externas.

### Maven

Herramienta de gestión del ciclo de vida del proyecto Java. Gestiona las dependencias declaradas en el archivo `pom.xml` y permite compilar, testear y empaquetar la aplicación con un único comando.

---

## 6. Diseño del proyecto

### 6.1 Diseño de la base de datos

#### Diagrama Entidad/Relación

![Diagrama E/R](./Entidad%20relación.png)

#### Modelo Relacional

```
usuarios (
    id PK,
    username UNIQUE,
    email UNIQUE,
    password_hash,
    puntos_logro,
    created_at,
    ultimo_acceso
)

partidas (
    id PK,
    jugador_id FK → usuarios(id),
    dificultad ENUM('FACIL','NORMAL','DIFICIL'),
    tiempo,
    numero_minas,
    minas_restantes,
    fecha_partida
)

logros (
    id PK,
    nombre,
    descripcion,
    puntos
)

usuario_logros (
    id PK,
    jugador_id FK → usuarios(id),
    logro_id FK → logros(id)
)

cosmeticos (
    id PK,
    nombre,
    estilo,
    imagen_url,
    precio_puntos
)

usuario_cosmeticos (
    id PK,
    jugador_id FK → usuarios(id),
    cosmetico_id FK → cosmeticos(id),
    equipado BIT
)
```

### 6.2 Carga de datos inicial

El script SQL con la estructura completa de la base de datos y los datos de prueba se encuentra en el [Anexo I](#anexo-i--script-sql-de-la-base-de-datos).

### 6.3 Diseño de la interfaz de usuario

El diseño de las pantallas se realizó con **Lunacy** ([Anexo II](#anexo-ii--diseño-prototipo-en-lunacy)) antes de proceder a la implementación, aunque conforme avanzó el desarrollo, este diseño acabó siendo un prototipo y la estética final cambió, manteniendo aún así gran parte de la idea original. La aplicación cuenta con las siguientes vistas principales:

| Pantalla | Descripción |
|---|---|
| **Página principal / Juego** | Tablero del Buscaminas con selector de dificultad y ranking visible, esta pantalla también incluye la funcionalidad de inicio de sesión |
| **Usuario / Ajustes** | Cambio de nombre de usuario, contraseña y eliminación de cuenta |
| **Historial de partidas** | Listado de partidas jugadas por el usuario registrado |
| **Logros** | Visualización de logros desbloqueados y pendientes |
| **Tienda de cosméticos** | Temas disponibles para comprar con puntos de logro |


La aplicación soporta dos temas adicionales desbloqueables además del tema por defecto:

- **Tema Hacker** — 150 puntos
- **Tema Pirata** — 200 puntos

El cambio de idioma entre **español** e **inglés** es dinámico y está disponible para cualquier usuario, sin necesidad de registro.

### 6.4 Roles de la aplicación

| Rol | Descripción |
|---|---|
| **Usuario no registrado** | Puede jugar al Buscaminas en cualquier dificultad y consultar el ranking global. También puede cambiar el idioma de la interfaz. |
| **Usuario registrado** | Además de lo anterior, tiene acceso al sistema de logros, historial de partidas, tienda de cosméticos, temas desbloqueados y ajustes de cuenta. |

### 6.5 Usuarios creados para pruebas

Los siguientes usuarios son algunos de los disponibles en la base de datos de prueba:

| Username | Email | Notas |
|---|---|---|
| `CarlosRey` | carlos.reyes@gmail.com | Usuario con todos los logros y cosméticos desbloqueados (1000 puntos) |
| `MiguelDiaz` | miguel.diaz@gmail.com | Usuario con logros de nivel avanzado |
| `AlejandroG` | alejandro.garcia@gmail.com | Usuario con logros básicos |
| `MariaL` | maria.lopez@hotmail.com | Usuario con logros de nivel medio |

De cara a hacer pruebas todos los usuarios tienen como contraseña el caracter "1", aún así en la base de datos se recogen como hash a modo de cifrado, gestionado por el programa.

---

## 7. Lógica y codificación del proyecto

### 7.1 Principales procesos

**Lógica del juego (Frontend — JavaScript)**

El tablero del Buscaminas se genera dinámicamente en el cliente mediante JavaScript. Se puede seleccionar la dificultad del juego mediante unos botones laterales, lo que determina el tamaño del tablero y el número de minas:

| Dificultad | Tamaño | Minas |
|---|---|---|
| Fácil | 10×8 | 10 |
| Normal | 18×14 | 40 |
| Difícil | 30×16 | 99 |

El algoritmo coloca las minas de forma aleatoria tras el primer clic (garantizando que el primer clic nunca es una mina) y calcula el número de minas adyacentes para cada celda. Al finalizar la partida (victoria o derrota), los datos se envían al backend mediante `fetch` para ser persistidos si hay un usuario con sesión iniciada.

**Sistema de logros**

Los logros se evalúan en el backend al recibir el resultado de una partida. Se comprueban condiciones victorias por dificultad o tiempo de resolución, y si se cumplen, se asocian al usuario y se suman los puntos correspondientes.

Los logros disponibles son:

| Logro | Descripción clave | Puntos |
|---|---|---|
| Incauto | Primera partida perdida | 10 |
| Principiante | Primera victoria en Fácil | 50 |
| Normalidad | Primera victoria en Normal | 100 |
| Experto | Primera victoria en Difícil | 150 |
| Velocista | Victoria en menos de 30 segundos | 150 |
| Temerario | Victoria sin usar banderas | 150 |

**Sistema de cosméticos**

Los usuarios registrados pueden gastar sus puntos de logro en la tienda para adquirir temas CSS alternativos. Al equipar un tema, la aplicación carga dinámicamente la hoja de estilos correspondiente (`theme-hacker.css`, `theme-pirate.css`), cambiando la apariencia completa de la interfaz sin recargar la página.

**Cambio de idioma dinámico**

El sistema de internacionalización (i18n) está implementado en el cliente con JavaScript. Se mantiene un objeto de traducciones para cada idioma y al cambiar el idioma se actualizan todos los textos del DOM sin recargar la página. Los textos descriptivos de los logros también están internacionalizados mediante claves.

### 7.2 Aspectos relevantes de la implementación

**Validación de datos**

La validación se realiza en dos niveles: en el cliente (JavaScript) antes de enviar el formulario, y en el servidor (Spring Boot) en los controladores REST.

**Control de acceso**

Spring Security gestiona la autenticación basada en sesión. Los endpoints de la API que requieren usuario autenticado están protegidos y devuelven `401 Unauthorized` si se intenta acceder sin sesión activa.

**Sistema de carpetas**

```
buscaminas
    |   .gitattributes
    |   .gitignore
    |   HELP.md
    |   mvnw
    |   mvnw.cmd
    |   pom.xml
    |   readme.md
    |   
    +---.mvn
    |   \---wrapper
    |           maven-wrapper.properties
    |           
    +---src
    |   +---main
    |   |   +---java
    |   |   |   \---com
    |   |   |       \---buscaminas
    |   |   |           \---buscaminas
    |   |   |               |   BuscaminasApplication.java
    |   |   |               |   
    |   |   |               +---config
    |   |   |               |       SecurityConfig.java
    |   |   |               |       
    |   |   |               +---controller
    |   |   |               |       AuthController.java
    |   |   |               |       CosmeticoController.java
    |   |   |               |       LogroController.java
    |   |   |               |       PartidaController.java
    |   |   |               |       UsuarioController.java
    |   |   |               |       UsuarioCosmeticoController.java
    |   |   |               |       UsuarioLogroController.java
    |   |   |               |       
    |   |   |               +---dto
    |   |   |               |       CosmeticoDTO.java
    |   |   |               |       LogroDTO.java
    |   |   |               |       PartidaDTO.java
    |   |   |               |       UsuarioCosmeticoDTO.java
    |   |   |               |       UsuarioDTO.java
    |   |   |               |       UsuarioLogroDTO.java
    |   |   |               |       
    |   |   |               +---model
    |   |   |               |       Cosmetico.java
    |   |   |               |       Logro.java
    |   |   |               |       Partida.java
    |   |   |               |       Usuario.java
    |   |   |               |       UsuarioCosmetico.java
    |   |   |               |       UsuarioLogro.java
    |   |   |               |       
    |   |   |               +---repository
    |   |   |               |       CosmeticoRepository.java
    |   |   |               |       LogroRepository.java
    |   |   |               |       PartidaRepository.java
    |   |   |               |       UsuarioCosmeticoRepository.java
    |   |   |               |       UsuarioLogroRepository.java
    |   |   |               |       UsuarioRepository.java
    |   |   |               |       
    |   |   |               \---util
    |   |   |                       CosmeticoConstants.java
    |   |   |                       
    |   |   \---resources
    |   |       |   application.properties
    |   |       |   
    |   |       +---static
    |   |       |   |   achievements.html
    |   |       |   |   historial.html
    |   |       |   |   minesweeper.html
    |   |       |   |   shop.html
    |   |       |   |   usuario.html
    |   |       |   |   
    |   |       |   +---css
    |   |       |   |       theme-classic.css
    |   |       |   |       theme-hacker.css
    |   |       |   |       theme-pirate.css
    |   |       |   |       
    |   |       |   +---font
    |   |       |   |       mine-sweeper.otf
    |   |       |   |       
    |   |       |   +---img
    |   |       |   |   |   face.webp
    |   |       |   |   |   flag.png
    |   |       |   |   |   minaTitle.png
    |   |       |   |   |   mine.png
    |   |       |   |   |   spanish.png
    |   |       |   |   |   unionjack.webp
    |   |       |   |   |   
    |   |       |   |   \---cosmeticos
    |   |       |   |           classic.png
    |   |       |   |           hacker.png
    |   |       |   |           pirate.png
    |   |       |   |           
    |   |       |   \---js
    |   |       |       |   i18n.js
    |   |       |       |   login.js
    |   |       |       |   navegacion.js
    |   |       |       |   rankingPublico.js
    |   |       |       |   tablero.js
    |   |       |       |   usuarioLogros.js
    |   |       |       |   
    |   |       |       \---i18n
    |   |       |               en.json
    |   |       |               es.json
    |   |       |               
    |   |       \---templates
    |   \---test
    |       \---java
    |           \---com
    |               \---buscaminas
    |                   \---buscaminas
    |                           BuscaminasApplicationTests.java
    |                           
    \---target
        |   buscaminas-0.0.1-SNAPSHOT.jar
        |   buscaminas-0.0.1-SNAPSHOT.jar.original
        |   
        +---classes
        |   |   application.properties
        |   |   
        |   +---com
        |   |   \---buscaminas
        |   |       \---buscaminas
        |   |           |   BuscaminasApplication.class
        |   |           |   
        |   |           +---config
        |   |           |       SecurityConfig.class
        |   |           |       
        |   |           +---controller
        |   |           |       AuthController.class
        |   |           |       CosmeticoController.class
        |   |           |       LogroController.class
        |   |           |       PartidaController.class
        |   |           |       UsuarioController.class
        |   |           |       UsuarioCosmeticoController.class
        |   |           |       UsuarioLogroController.class
        |   |           |       
        |   |           +---dto
        |   |           |       CosmeticoDTO.class
        |   |           |       LogroDTO.class
        |   |           |       PartidaDTO$1.class
        |   |           |       PartidaDTO.class
        |   |           |       UsuarioCosmeticoDTO.class
        |   |           |       UsuarioDTO.class
        |   |           |       UsuarioLogroDTO.class
        |   |           |       
        |   |           +---model
        |   |           |       Cosmetico.class
        |   |           |       Logro.class
        |   |           |       Partida$Dificultad.class
        |   |           |       Partida.class
        |   |           |       Usuario.class
        |   |           |       UsuarioCosmetico.class
        |   |           |       UsuarioLogro.class
        |   |           |       
        |   |           +---repository
        |   |           |       CosmeticoRepository.class
        |   |           |       LogroRepository.class
        |   |           |       PartidaRepository.class
        |   |           |       UsuarioCosmeticoRepository.class
        |   |           |       UsuarioLogroRepository.class
        |   |           |       UsuarioRepository.class
        |   |           |       
        |   |           \---util
        |   |                   CosmeticoConstants.class
        |   |                   
        |   \---static
        |       |   achievements.html
        |       |   historial.html
        |       |   minesweeper.html
        |       |   shop.html
        |       |   usuario.html
        |       |   
        |       +---css
        |       |       theme-classic.css
        |       |       theme-hacker.css
        |       |       theme-pirate.css
        |       |       
        |       +---font
        |       |       mine-sweeper.otf
        |       |       
        |       +---img
        |       |   |   face.webp
        |       |   |   flag.png
        |       |   |   minaTitle.png
        |       |   |   mine.png
        |       |   |   spanish.png
        |       |   |   unionjack.webp
        |       |   |   
        |       |   \---cosmeticos
        |       |           classic.png
        |       |           hacker.png
        |       |           pirate.png
        |       |           
        |       \---js
        |           |   i18n.js
        |           |   login.js
        |           |   navegacion.js
        |           |   rankingPublico.js
        |           |   tablero.js
        |           |   usuarioLogros.js
        |           |   
        |           \---i18n
        |                   en.json
        |                   es.json
        |                   
        +---generated-sources
        |   \---annotations
        +---generated-test-sources
        |   \---test-annotations
        +---maven-archiver
        |       pom.properties
        |       
        +---maven-status
        |   \---maven-compiler-plugin
        |       +---compile
        |       |   \---default-compile
        |       |           createdFiles.lst
        |       |           inputFiles.lst
        |       |           
        |       \---testCompile
        |           \---default-testCompile
        |                   createdFiles.lst
        |                   inputFiles.lst
        |                   
        +---surefire-reports
        |       com.buscaminas.buscaminas.BuscaminasApplicationTests.txt
        |       TEST-com.buscaminas.buscaminas.BuscaminasApplicationTests.xml
        |       
        \---test-classes
            \---com
                \---buscaminas
                    \---buscaminas
                            BuscaminasApplicationTests.class
                            

```

---

## 8. Despliegue web del proyecto

La aplicación está diseñada para ejecutarse en local durante la fase de desarrollo y evaluación. No requiere un servidor externo ni configuración de hosting.

### Requisitos de hardware

- Procesador: cualquier CPU moderna (x64)
- RAM: mínimo 512 MB disponibles para la JVM
- Almacenamiento: ~100 MB para el proyecto y la base de datos

### Servidores utilizados

| Servidor | Descripción |
|---|---|
| **Apache Tomcat (embebido)** | Incluido en Spring Boot. Se inicia automáticamente al lanzar la aplicación. Puerto por defecto: `8080` |
| **MariaDB 12.2.2** | Servidor de base de datos local. Puerto por defecto: `3306` |

### Seguridad

- Las contraseñas de los usuarios se almacenan cifradas mediante Spring Security.
- La comunicación en entorno local se realiza por HTTP; en un despliegue en producción se debería configurar HTTPS con un certificado TLS.

### Instrucciones de despliegue local

**Requisitos previos:**
- Java 21 o superior
- Maven 3.x
- MariaDB instalado y en ejecución

**Pasos:**

```bash
# 1. Clonar el repositorio
git clone https://github.com/suarezfigueroa/2025-2026_FranciscoManuelPalo
cd 2025-2026_FranciscoManuelPalo

# 2. Crear el esquema de base de datos de nombre "buscaminas" en MariaDB
# Ejecutar el script del Anexo III desde HeidiSQL o la CLI de MariaDB para cargar los datos iniciales, las tablas se 
# generaran solas con Spring Boot

# 3. Configurar la conexión en src/main/resources/application.properties
# spring.datasource.url=jdbc:mariadb://localhost:3306/buscaminas
# spring.datasource.username=TU_USUARIO
# spring.datasource.password=TU_CONTRASEÑA
#
# Para este propósito se incluye un archivo llamado _application.properties listo
# para introducir usuario y contraseña, después de eso solo hay que quitar la _ 
# del nombre.

# 4. Compilar y arrancar la aplicación(clean install solo la primera vez)
mvn clean install 
mvn spring-boot:run

# 5. Acceder desde el navegador
# http://localhost:8080
```

---

## 9. Manual de usuario

> *El manual de usuario completo, con instrucciones detalladas para cada rol, se encuentra en el archivo [`MANUAL.md`](./MANUAL.md).*

El manual incluye los siguientes apartados:

- **Usuario no registrado**: cómo iniciar una partida, seleccionar dificultad y consultar el ranking.
- **Usuario registrado**: registro, inicio de sesión, sistema de logros, tienda de cosméticos, cambio de tema, historial de partidas y gestión de cuenta.

---

## 10. Conclusiones y aspectos a mejorar

El desarrollo de **Minesweeper** ha supuesto un reto completo de principio a fin, abarcando desde el diseño de la base de datos hasta la implementación de la lógica del juego en el cliente. 

Los aspectos que más aprendizaje han generado han sido la **estructura del backend con Spring Boot**, que implica comprender la separación en capas (controlador, servicio, repositorio), la inyección de dependencias y la configuración de seguridad con Spring Security; y la **capacidad de dinamismo de JavaScript**, que permite construir interfaces reactivas sin necesidad de frameworks, actualizando el DOM, gestionando el estado del juego y comunicándose con el backend de forma asíncrona mediante `fetch`.

**Retos afrontados:**
- Implementar el sistema de temas CSS de forma dinámica, cargando y descargando hojas de estilos en tiempo de ejecución.
- Diseñar la lógica del Buscaminas en JavaScript de forma limpia y mantenible, especialmente el algoritmo de revelado recursivo de celdas vacías.

**Aspectos a mejorar en futuras versiones:**
- Añadir un panel de administración para gestionar usuarios, logros y cosméticos.
- Añadir un diseño responsive de cara al uso de la aplicación en dispositivos móviles.
- Implementar un modo multijugador aprovechando la dependencia WebSocket que se puede incluir con Spring Boot.
- Desplegar la aplicación en un servidor en la nube para que sea accesible públicamente.
- Añadir más temas estéticos y logros para enriquecer la progresión del jugador.
- Implementar un modo de dificultad personalizado donde el jugador configure filas, columnas y número de minas.

---

## 11. Bibliografía

| Recurso | URL |
|---|---|
| Documentación oficial de Spring Boot | [docs.spring.io/spring-boot](https://docs.spring.io/spring-boot/docs/current/reference/html/) |
| Documentación de Spring Security | [docs.spring.io/spring-security](https://docs.spring.io/spring-security/reference/index.html) |
| Spring Data JPA — Guía oficial | [spring.io/guides/gs/accessing-data-jpa](https://spring.io/guides/gs/accessing-data-jpa/) |
| Baeldung — Spring Security | [baeldung.com/security-spring](https://www.baeldung.com/security-spring) |
| Documentación de Maven | [maven.apache.org/guides](https://maven.apache.org/guides/index.html) |
| Formato Markdown (GitHub) | [docs.github.com — Markdown syntax](https://docs.github.com/es/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax) |
| Apoyo de inteligencia artificial | [claude](claude.ai) |

---

## Anexo I — Script SQL de la base de datos

El siguiente script contiene la estructura completa de la base de datos (`DDL`), exportado desde HeidiSQL, su uso se limita a la compresión de la estructura de la base datos puesto que Spring Boot genera las tablas. Así pues el sql pensado para ejecutarse será el del ([Anexo III](#anexo-iii--script-sql-de-datos-de-prueba)).

```sql
-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         12.2.2-MariaDB - MariaDB Server
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.14.0.7165
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando estructura para tabla buscaminas.cosmeticos
CREATE TABLE IF NOT EXISTS `cosmeticos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `estilo` varchar(100) DEFAULT NULL,
  `imagen_url` varchar(255) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio_puntos` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla buscaminas.logros
CREATE TABLE IF NOT EXISTS `logros` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `puntos` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla buscaminas.partidas
CREATE TABLE IF NOT EXISTS `partidas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dificultad` enum('DIFICIL','FACIL','NORMAL') NOT NULL,
  `fecha_partida` datetime(6) DEFAULT NULL,
  `minas_restantes` int(11) NOT NULL,
  `numero_minas` int(11) NOT NULL,
  `tiempo` int(11) NOT NULL,
  `jugador_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKim3ksy7ukis8sjhygl1mytn3d` (`jugador_id`),
  CONSTRAINT `FKim3ksy7ukis8sjhygl1mytn3d` FOREIGN KEY (`jugador_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla buscaminas.usuario_cosmeticos
CREATE TABLE IF NOT EXISTS `usuario_cosmeticos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `equipado` bit(1) NOT NULL,
  `cosmetico_id` bigint(20) NOT NULL,
  `jugador_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhgmbduv1o267onge2psxphtsn` (`cosmetico_id`),
  KEY `FKkscui4nr87rok9cmepuvnrakc` (`jugador_id`),
  CONSTRAINT `FKhgmbduv1o267onge2psxphtsn` FOREIGN KEY (`cosmetico_id`) REFERENCES `cosmeticos` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKkscui4nr87rok9cmepuvnrakc` FOREIGN KEY (`jugador_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla buscaminas.usuario_logros
CREATE TABLE IF NOT EXISTS `usuario_logros` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `jugador_id` bigint(20) NOT NULL,
  `logro_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlo2nbj8vb7y1qqqqmxsqdr6a3` (`jugador_id`),
  KEY `FKe9atm8496glld8c6x2nwro96n` (`logro_id`),
  CONSTRAINT `FKe9atm8496glld8c6x2nwro96n` FOREIGN KEY (`logro_id`) REFERENCES `logros` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKlo2nbj8vb7y1qqqqmxsqdr6a3` FOREIGN KEY (`jugador_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla buscaminas.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `puntos_logro` int(11) NOT NULL,
  `ultimo_acceso` datetime(6) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKkfsp0s1tflm1cwlj8idhqsad0` (`email`),
  UNIQUE KEY `UKm2dvbwfge291euvmk6vkkocao` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- La exportación de datos fue deseleccionada.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

```

> El script completo con toda la estructura se encuentra en el archivo [`Estructura datos(Anexo I).sql`](./Estructura%20datos(Anexo%20I).sql) del repositorio.


## Anexo II — Diseño prototipo en Lunacy

> [`Diseño prototipo(Anexo II).free`](./Diseño%20prototipo(Anexo%20II).free)

## Anexo III — Script SQL de datos de prueba
Este script contiene los datos de prueba (`DML`) usados en la página, solo es necesario este a modo de insert para el funcionamiento de la aplicación web ya que Spring Boot se encarga de generar las tablas de sus modelos. Importante crear previamente una base de datos con el nombre "buscaminas".

```sql
-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         12.2.2-MariaDB - MariaDB Server
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.14.0.7165
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando datos para la tabla buscaminas.cosmeticos: ~2 rows (aproximadamente)
INSERT INTO `cosmeticos` (`id`, `estilo`, `imagen_url`, `nombre`, `precio_puntos`) VALUES
	(2, 'theme-hacker.css', './img/cosmeticos/hacker.png', 'Tema hacker', 150),
	(3, 'theme-pirate.css', './img/cosmeticos/pirate.png', 'Tema pirata', 200);

-- Volcando datos para la tabla buscaminas.logros: ~6 rows (aproximadamente)
INSERT INTO `logros` (`id`, `descripcion`, `nombre`, `puntos`) VALUES
	(10, 'logros.incauto.desc', 'incauto', 10),
	(11, 'logros.principiante.desc', 'principiante', 50),
	(12, 'logros.normalidad.desc', 'normalidad', 100),
	(13, 'logros.experto.desc', 'experto', 150),
	(14, 'logros.velocista.desc', 'velocista', 150),
	(15, 'logros.temerario.desc', 'temerario', 150);

-- Volcando datos para la tabla buscaminas.partidas: ~100 rows (aproximadamente)
INSERT INTO `partidas` (`id`, `dificultad`, `fecha_partida`, `minas_restantes`, `numero_minas`, `tiempo`, `jugador_id`) VALUES
	(1, 'FACIL', '2025-03-01 10:00:00.000000', 0, 10, 45, 1),
	(2, 'FACIL', '2025-03-05 11:15:00.000000', 2, 10, 38, 1),
	(3, 'NORMAL', '2025-03-10 14:30:00.000000', 5, 40, 120, 1),
	(4, 'NORMAL', '2025-03-15 16:00:00.000000', 0, 40, 98, 1),
	(5, 'DIFICIL', '2025-03-20 18:45:00.000000', 20, 99, 300, 1),
	(6, 'FACIL', '2025-04-01 09:00:00.000000', 1, 10, 52, 1),
	(7, 'NORMAL', '2025-04-08 13:00:00.000000', 8, 40, 145, 1),
	(8, 'DIFICIL', '2025-04-15 20:00:00.000000', 10, 99, 275, 1),
	(9, 'NORMAL', '2025-04-22 17:30:00.000000', 0, 40, 110, 1),
	(10, 'DIFICIL', '2025-05-01 21:00:00.000000', 0, 99, 330, 1),
	(11, 'FACIL', '2025-03-02 10:00:00.000000', 0, 10, 30, 2),
	(12, 'FACIL', '2025-03-06 12:00:00.000000', 3, 10, 25, 2),
	(13, 'FACIL', '2025-03-11 09:30:00.000000', 0, 10, 28, 2),
	(14, 'NORMAL', '2025-03-16 14:00:00.000000', 12, 40, 180, 2),
	(15, 'NORMAL', '2025-03-21 16:30:00.000000', 6, 40, 155, 2),
	(16, 'FACIL', '2025-04-02 10:00:00.000000', 0, 10, 22, 2),
	(17, 'NORMAL', '2025-04-09 11:00:00.000000', 0, 40, 130, 2),
	(18, 'NORMAL', '2025-04-16 15:00:00.000000', 3, 40, 142, 2),
	(19, 'DIFICIL', '2025-04-23 19:00:00.000000', 30, 99, 400, 2),
	(20, 'DIFICIL', '2025-05-02 20:30:00.000000', 15, 99, 360, 2),
	(21, 'DIFICIL', '2025-03-03 08:00:00.000000', 0, 99, 180, 3),
	(22, 'DIFICIL', '2025-03-07 09:00:00.000000', 0, 99, 165, 3),
	(23, 'DIFICIL', '2025-03-12 10:00:00.000000', 0, 99, 172, 3),
	(24, 'DIFICIL', '2025-03-17 11:00:00.000000', 0, 99, 158, 3),
	(25, 'DIFICIL', '2025-03-22 12:00:00.000000', 0, 99, 190, 3),
	(26, 'DIFICIL', '2025-04-03 08:30:00.000000', 0, 99, 161, 3),
	(27, 'DIFICIL', '2025-04-10 09:30:00.000000', 0, 99, 155, 3),
	(28, 'NORMAL', '2025-04-17 10:30:00.000000', 0, 40, 75, 3),
	(29, 'DIFICIL', '2025-04-24 08:00:00.000000', 0, 99, 148, 3),
	(30, 'DIFICIL', '2025-05-03 07:45:00.000000', 0, 99, 140, 3),
	(31, 'FACIL', '2025-03-04 10:00:00.000000', 4, 10, 60, 4),
	(32, 'FACIL', '2025-03-08 11:30:00.000000', 0, 10, 48, 4),
	(33, 'NORMAL', '2025-03-13 14:00:00.000000', 10, 40, 200, 4),
	(34, 'FACIL', '2025-03-18 15:00:00.000000', 2, 10, 55, 4),
	(35, 'NORMAL', '2025-03-23 17:00:00.000000', 4, 40, 175, 4),
	(36, 'NORMAL', '2025-04-04 10:00:00.000000', 0, 40, 160, 4),
	(37, 'DIFICIL', '2025-04-11 14:00:00.000000', 25, 99, 420, 4),
	(38, 'FACIL', '2025-04-18 09:00:00.000000', 0, 10, 42, 4),
	(39, 'NORMAL', '2025-04-25 16:00:00.000000', 7, 40, 190, 4),
	(40, 'DIFICIL', '2025-05-04 20:00:00.000000', 18, 99, 380, 4),
	(41, 'NORMAL', '2025-03-05 10:00:00.000000', 15, 40, 220, 5),
	(42, 'NORMAL', '2025-03-09 12:00:00.000000', 8, 40, 195, 5),
	(43, 'DIFICIL', '2025-03-14 15:00:00.000000', 40, 99, 500, 5),
	(44, 'FACIL', '2025-03-19 09:00:00.000000', 0, 10, 35, 5),
	(45, 'NORMAL', '2025-03-24 14:00:00.000000', 2, 40, 165, 5),
	(46, 'FACIL', '2025-04-05 11:00:00.000000', 1, 10, 40, 5),
	(47, 'NORMAL', '2025-04-12 13:00:00.000000', 0, 40, 150, 5),
	(48, 'DIFICIL', '2025-04-19 18:00:00.000000', 22, 99, 440, 5),
	(49, 'FACIL', '2025-04-26 10:00:00.000000', 0, 10, 32, 5),
	(50, 'NORMAL', '2025-05-05 15:00:00.000000', 5, 40, 178, 5),
	(51, 'FACIL', '2025-03-06 09:00:00.000000', 0, 10, 27, 6),
	(52, 'FACIL', '2025-03-10 10:00:00.000000', 0, 10, 31, 6),
	(53, 'FACIL', '2025-03-15 11:00:00.000000', 1, 10, 36, 6),
	(54, 'NORMAL', '2025-03-20 14:00:00.000000', 18, 40, 240, 6),
	(55, 'FACIL', '2025-03-25 09:30:00.000000', 0, 10, 29, 6),
	(56, 'NORMAL', '2025-04-06 12:00:00.000000', 9, 40, 210, 6),
	(57, 'FACIL', '2025-04-13 10:00:00.000000', 0, 10, 24, 6),
	(58, 'NORMAL', '2025-04-20 14:30:00.000000', 0, 40, 185, 6),
	(59, 'DIFICIL', '2025-04-27 19:00:00.000000', 35, 99, 460, 6),
	(60, 'NORMAL', '2025-05-06 16:00:00.000000', 4, 40, 168, 6),
	(61, 'DIFICIL', '2025-03-07 08:00:00.000000', 12, 99, 350, 7),
	(62, 'NORMAL', '2025-03-11 10:30:00.000000', 0, 40, 125, 7),
	(63, 'DIFICIL', '2025-03-16 13:00:00.000000', 5, 99, 290, 7),
	(64, 'NORMAL', '2025-03-21 15:00:00.000000', 3, 40, 140, 7),
	(65, 'DIFICIL', '2025-03-26 18:00:00.000000', 0, 99, 260, 7),
	(66, 'NORMAL', '2025-04-07 09:00:00.000000', 0, 40, 118, 7),
	(67, 'DIFICIL', '2025-04-14 11:00:00.000000', 8, 99, 310, 7),
	(68, 'FACIL', '2025-04-21 08:30:00.000000', 0, 10, 20, 7),
	(69, 'DIFICIL', '2025-04-28 20:00:00.000000', 0, 99, 245, 7),
	(70, 'NORMAL', '2025-05-07 14:00:00.000000', 1, 40, 132, 7),
	(71, 'FACIL', '2025-03-08 10:00:00.000000', 5, 10, 70, 8),
	(72, 'FACIL', '2025-03-12 11:00:00.000000', 3, 10, 65, 8),
	(73, 'FACIL', '2025-03-17 09:30:00.000000', 0, 10, 50, 8),
	(74, 'NORMAL', '2025-03-22 14:00:00.000000', 20, 40, 260, 8),
	(75, 'FACIL', '2025-03-27 10:00:00.000000', 2, 10, 58, 8),
	(76, 'FACIL', '2025-04-08 09:00:00.000000', 0, 10, 44, 8),
	(77, 'NORMAL', '2025-04-15 13:00:00.000000', 14, 40, 230, 8),
	(78, 'NORMAL', '2025-04-22 15:30:00.000000', 6, 40, 200, 8),
	(79, 'DIFICIL', '2025-04-29 19:30:00.000000', 45, 99, 520, 8),
	(80, 'NORMAL', '2025-05-08 16:00:00.000000', 0, 40, 175, 8),
	(81, 'NORMAL', '2025-03-09 08:00:00.000000', 0, 40, 95, 9),
	(82, 'DIFICIL', '2025-03-13 10:00:00.000000', 3, 99, 230, 9),
	(83, 'NORMAL', '2025-03-18 12:00:00.000000', 0, 40, 88, 9),
	(84, 'DIFICIL', '2025-03-23 14:00:00.000000', 0, 99, 210, 9),
	(85, 'NORMAL', '2025-03-28 16:00:00.000000', 1, 40, 102, 9),
	(86, 'DIFICIL', '2025-04-09 09:00:00.000000', 0, 99, 198, 9),
	(87, 'NORMAL', '2025-04-16 10:00:00.000000', 0, 40, 91, 9),
	(88, 'DIFICIL', '2025-04-23 11:00:00.000000', 2, 99, 220, 9),
	(89, 'FACIL', '2025-04-30 08:00:00.000000', 0, 10, 18, 9),
	(90, 'DIFICIL', '2025-05-09 07:30:00.000000', 0, 99, 195, 9),
	(91, 'FACIL', '2025-03-10 10:00:00.000000', 6, 10, 80, 10),
	(92, 'FACIL', '2025-03-14 11:00:00.000000', 4, 10, 72, 10),
	(93, 'NORMAL', '2025-03-19 14:00:00.000000', 22, 40, 280, 10),
	(94, 'FACIL', '2025-03-24 09:00:00.000000', 1, 10, 66, 10),
	(95, 'FACIL', '2025-03-29 10:30:00.000000', 0, 10, 54, 10),
	(96, 'NORMAL', '2025-04-10 12:00:00.000000', 11, 40, 250, 10),
	(97, 'FACIL', '2025-04-17 09:00:00.000000', 0, 10, 46, 10),
	(98, 'NORMAL', '2025-04-24 14:00:00.000000', 5, 40, 215, 10),
	(99, 'DIFICIL', '2025-05-01 18:00:00.000000', 50, 99, 540, 10),
	(100, 'NORMAL', '2025-05-10 15:00:00.000000', 0, 40, 188, 10);

-- Volcando datos para la tabla buscaminas.usuario_cosmeticos: ~4 rows (aproximadamente)
INSERT INTO `usuario_cosmeticos` (`id`, `equipado`, `cosmetico_id`, `jugador_id`) VALUES
	(1, b'0', 2, 3),
	(2, b'1', 3, 3),
	(3, b'1', 2, 7),
	(4, b'1', 2, 9);

-- Volcando datos para la tabla buscaminas.usuario_logros: ~21 rows (aproximadamente)
INSERT INTO `usuario_logros` (`id`, `jugador_id`, `logro_id`) VALUES
	(1, 1, 10),
	(2, 1, 11),
	(3, 2, 10),
	(4, 2, 11),
	(5, 2, 12),
	(6, 3, 10),
	(7, 3, 11),
	(8, 3, 12),
	(9, 3, 13),
	(10, 3, 14),
	(11, 3, 15),
	(12, 4, 10),
	(13, 5, 10),
	(14, 5, 12),
	(15, 6, 10),
	(16, 6, 11),
	(17, 7, 12),
	(18, 7, 13),
	(19, 9, 13),
	(20, 9, 14),
	(21, 9, 15);

-- Volcando datos para la tabla buscaminas.usuarios: ~10 rows (aproximadamente)
INSERT INTO `usuarios` (`id`, `created_at`, `email`, `password_hash`, `puntos_logro`, `ultimo_acceso`, `username`) VALUES
	(1, '2024-11-01 09:15:00.000000', 'alejandro.garcia@gmail.com', '$2a$10$jTIdi13GQpJHYDl9pmUgs.ued94OM/lp6useBImet1ShmsuxAYFyi', 0, '2025-05-10 18:30:00.000000', 'AlejandroG'),
	(2, '2024-11-15 14:20:00.000000', 'maria.lopez@hotmail.com', '$2a$10$qNpNAzyVjDWn2U4OmMaspOGY8Rrus/CwKsn3M3fo.YRtUPUMMkE2G', 0, '2025-05-18 21:00:00.000000', 'MariaL'),
	(3, '2024-10-05 08:00:00.000000', 'carlos.reyes@gmail.com', '$2a$10$CWtAbNxKpsi5fysRxHrRXuWx84CBtQ0MGauP0MgyXgCZlO0k7A7Xa', 1000, '2025-05-28 10:45:00.000000', 'CarlosRey'),
	(4, '2024-12-01 17:30:00.000000', 'lucia.fernandez@yahoo.com', '$2a$10$mS0BFA05TLJoZjV.ibuD0.ouXcXY/n2gVcc4Ejgtda0QNCwvHX78m', 0, '2025-05-20 16:15:00.000000', 'LuciaFdez'),
	(5, '2025-01-10 11:00:00.000000', 'pablo.martin@gmail.com', '$2a$10$nXzYbT0xoe2ck1UdJZRxoOFM1bnx8IfxHNesRzfm040SmiqgpfUY6', 0, '2025-05-25 09:30:00.000000', 'PabloM'),
	(6, '2025-01-22 13:45:00.000000', 'sofia.ruiz@outlook.com', '$2a$10$mWLpndBNi91B6KtaI5wNWeHEKZuwNbQvIrvBUjjkhFaD38igSaAzi', 0, '2025-05-27 20:00:00.000000', 'SofiaRuiz'),
	(7, '2025-02-03 10:10:00.000000', 'david.sanchez@gmail.com', '$2a$10$SIO2W/RFeEZJdYdJNAh.lu6hiE.tyCBcm2NXzAvzvPYdKQs.X91s6', 0, '2025-05-22 14:50:00.000000', 'DavidS'),
	(8, '2025-02-18 16:00:00.000000', 'elena.torres@hotmail.com', '$2a$10$wGobtU5txB5ioseE8jlUQevYEx9eU995THjg/5OoN1jOUDDYxCPM.', 0, '2025-05-15 11:20:00.000000', 'ElenaTorres'),
	(9, '2025-03-05 09:30:00.000000', 'miguel.diaz@gmail.com', '$2a$10$5Ei1MleL5joakyfR/xwhjeXd/S/uMbQfy2dG/r3SHCy7hcQyn8ng.', 0, '2025-05-29 08:00:00.000000', 'MiguelDiaz'),
	(10, '2025-03-20 12:00:00.000000', 'ana.jimenez@yahoo.com', '$2a$10$V3RxF5RKzzVbKN05Sa3eredkbcV0hOEXVU3MyZv60JcRGn8f5KI4C', 0, '2025-05-26 19:45:00.000000', 'AnaJimenez');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

```
> El script completo con todos los datos de partidas y usuarios de prueba se encuentra en el archivo [`Datos buscaminas(Anexo III).sql`](./Datos%20buscaminas(Anexo%20III).sql) del repositorio.
