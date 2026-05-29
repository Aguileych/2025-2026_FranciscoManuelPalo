# Manual de Usuario — Minesweeper

## Índice

1. [Introducción](#introducción)
2. [Acceso a la aplicación](#acceso-a-la-aplicación)
3. [Registro e inicio de sesión](#registro-e-inicio-de-sesión)
4. [El juego](#el-juego)
5. [Scoreboard](#scoreboard)
6. [Logros](#logros)
7. [Historial de partidas](#historial-de-partidas)
8. [Tienda de cosméticos](#tienda-de-cosméticos)
9. [Perfil de usuario](#perfil-de-usuario)
10. [Idioma](#idioma)

---

## Introducción

Minesweeper es un juego clásico de buscaminas con sistema de usuarios, logros, historial de partidas y tienda de cosméticos. Los jugadores pueden registrarse para guardar su progreso, desbloquear logros y personalizar la apariencia del juego. Debido a la fuente usada se ha optado porque no haya tildes ni letras "ñ", por ende palabras como contraseña se mostrarán como contrasena, o fácil como facil. Debido a que la aplicación está configurada en distintos idiomas, se intentará evitar en este manual el uso explícito de texto en un idioma concreto.

---

## Acceso a la aplicación

La aplicación es accesible desde cualquier navegador moderno en la red local. No es necesario instalar nada.

La página principal es accesible sin necesidad de tener una cuenta. Desde ella se puede jugar y consultar el ranking global de partidas.

El resto de secciones — logros, historial, tienda y perfil — requieren haber iniciado sesión.

---

## Registro e inicio de sesión

### Registro

Cualquier usuario puede crear una cuenta de forma libre desde el botón superior derecho del encabezado de la página principal.

1. Pulsar el botón en la esquina superior derecha.
2. Pulsa en el texto que indica registrarse en la parte inferior para cambiar al formulario de registro.
3. Rellenar los campos: correo electrónico, nombre de usuario y contraseña.
4. Pulsar el botón de registro.

### Inicio de sesión

1. Pulsar el botón en la esquina superior derecha.
2. Introducer tu correo electrónico y contraseña.
3. Pulsar el botón de inicio de sesión.

Tras iniciar sesión, el botón del encabezado mostrará tu nombre de usuario en lugar del texto predeterminado.

### Cierre de sesión

Pulsar el nombre de usuario en el encabezado y clickar el botón de cierre de sesión. La sesión se cerrará y se redirige a la página principal.

---

## El juego

### Cómo jugar

El tablero contiene celdas ocultas, algunas de las cuales esconden minas. El objetivo es revelar todas las celdas sin minas.

- **Click izquierdo** sobre una celda para revelarla.
- **Click derecho** sobre una celda para marcarla con una bandera si sospechas que contiene una mina.
- **Click derecho** sobre una celda marcada con una bandera para marcarla como dudosa.
- **Click derecho** soble una celda marcada como dudosa para desmarcarla.
- Si una celda revelada muestra un número, indica cuántas minas hay en las celdas adyacentes.
- Si se revela una mina, la partida termina con una derrota.
- Si se revelan todas las casillas sin mina, la partida termina con una victoria.

### Dificultades

El juego tiene tres dificultades seleccionables desde el panel izquierdo:

| Dificultad | Descripción |
|---|---|
| **Fácil** | Tablero pequeño con pocas minas. Recomendado para aprender. |
| **Normal** | Tablero mediano con dificultad estándar. |
| **Difícil** | Tablero grande con muchas minas. Para jugadores experimentados. |

### Contadores

En la parte superior del tablero hay dos contadores:

- **Contador izquierdo** — número de minas restantes sin marcar.
- **Contador derecho** — tiempo transcurrido desde el inicio de la partida en segundos.

### Reiniciar

Pulsa el botón central entre los contadores en el encabezado del tablero para reiniciar la partida en cualquier momento.

### Guardado de partidas

Si has iniciado sesión, cada partida completada se guarda automáticamente en tu historial al terminar, independientemente del resultado.

Los jugadores sin cuenta no tienen historial guardado.

---

## Scoreboard

En la página principal, el panel derecho muestra el ranking global de partidas por dificultad.

Puedes filtrar entre dificultades usando los botones de la cabecera del panel. El ranking muestra las mejores partidas de todos los jugadores ordenadas por tiempo.

Este ranking es visible para todos los usuarios, con o sin sesión iniciada.

---

## Logros

Accesible desde el menú pulsando su botón correspondiente. Requiere sesión iniciada.

Los logros son retos que se desbloquean automáticamente al cumplir ciertas condiciones durante el juego. Cada logro otorga una cantidad de puntos que se suman a tu saldo.

### Estados de un logro

| Estado | Descripción |
|---|---|
| **Desbloqueado** | El logro ha sido conseguido. |
| **Bloqueado** | El logro aún no ha sido conseguido. |

### Puntos de logro

Los puntos obtenidos al desbloquear logros son la divisa de la aplicación. Se usan para comprar cosméticos en la tienda. El saldo actual se puede consultar en la tienda.

---

## Historial de partidas

Accesible desde el menú. Requiere sesión iniciada.

Muestra todas las partidas jugadas con tu cuenta, ordenadas de la más reciente a la más antigua.

### Columnas

| Columna | Descripción |
|---|---|
| **Dificultad** | Dificultad de la partida. |
| **Resultado** | Victoria o derrota. |
| **Duracion** | Tiempo que duró la partida en segundos. |
| **Minas restantes** | Minas que quedaban sin revelar al terminar. |
| **Fecha** | Fecha y hora en que se jugó la partida. |

Una partida se considera victoria cuando todas las minas quedan marcadas y no se ha explotado ninguna. Se considera derrota si se revela una mina.

### Filtros

Puedes filtrar el historial usando los botones de la cabecera:

- **Dificultad** — filtra por Facil, Normal, Dificil o todas.
- **Resultado** — filtra por victorias, derrotas o todas.

Los filtros se pueden combinar entre sí.

### Estadísticas

En la parte inferior del historial se muestran estadísticas calculadas sobre las partidas filtradas en ese momento:

- Total de partidas, victorias y derrotas.
- Porcentaje de victorias.
- Tiempo medio por partida.
- Mejor tiempo en una victoria.

---

## Tienda de cosméticos

Accesible desde el menú **Shop**. Requiere sesión iniciada.

La tienda permite comprar y equipar temas visuales que cambian la apariencia del juego. El saldo de puntos disponible se muestra en la cabecera de la tienda.

### Estado de cada cosmético

| Estado | Descripción |
|---|---|
| **Equipado** | El tema está activo actualmente. |
| **Obtenido** | El tema está comprado pero no equipado. |
| Sin estado | El tema no ha sido comprado. |

### Comprar un cosmético

1. Comprueba que tienes puntos suficientes — el precio aparece en la parte inferior de cada cosmético.
2. Pulsa **Comprar**.
3. Los puntos se descuentan automáticamente de tu saldo.

Los cosméticos marcados como **Gratis** no tienen coste y se pueden equipar sin ningún tipo de requisito.

### Equipar un cosmético

1. Pulsa **Equipar** en cualquier cosmético que ya tengas comprado.
2. El tema se aplica inmediatamente.

Solo puede haber un tema equipado a la vez. Al equipar uno nuevo, el anterior se desequipa automáticamente.

El tema equipado se conserva entre sesiones — al iniciar sesión en otro momento o desde otro equipo de la red, el tema activo se recupera automáticamente.

### Cambiar tema desde el juego

En la página principal, el selector del panel izquierdo muestra únicamente los temas que tienes comprados. Seleccionar uno lo equipa directamente sin necesidad de ir a la tienda, el tema clásico aparecerá siempre.

---

## Perfil de usuario

Accesible desde el menú. Requiere sesión iniciada.

Desde esta sección puedes gestionar los datos de tu cuenta.

### Cambiar nombre de usuario

1. Panel izquierdo
2. El nombre actual aparece en el campo superior.
3. Escribir el nuevo nombre en el campo inferior.
4. Pulsar el botón de guardado.


### Cambiar contraseña

1. Panel central
2. Introducir la contraseña actual en el campo superior.
3. Introducir la nueva contraseña en campo central.
4. Repetir la nueva contraseña en el campo inferior.
5. Pulsar el botón de guardado.


### Eliminar cuenta

La eliminación de la cuenta es una acción permanente e irreversible. Todos los datos asociados — partidas, logros y cosméticos — se perderán.

Para confirmar la eliminación:
1. Panel derecho
2. Introducir tu contraseña en el campo superior.
3. Escribir la palabra `DELETE` en el campo de confirmación (esta palabra es común a todos los idiomas de la aplicación).
4. Pulsar el botón inferior.

Tras la eliminación serás redirigido automáticamente a la página principal.

---

## Idioma

La aplicación está disponible en inglés y español. El botón de idioma se encuentra en la esquina superior derecha del encabezado, junto al botón de login.

Pulsa el botón para alternar entre los dos idiomas. El idioma seleccionado se conserva durante toda la sesión de navegación.
