////////////////////////LOGROS//////////////////////////////
let logrosObtenidos = new Set();
let banderasPuestas = false;
let logroToastTimer = null;

function mostrarLogroObtenido(nombre, puntos) {
  const text = document.getElementById("logroToast");
  text.textContent = `${t("ok.achievementUnlocked")}: ${t("logros." + nombre + ".nombre")} (+${puntos} pts)`;
  text.className = "usr-toast retro-bevel usr-toast--ok usr-toast--visible";
  clearTimeout(logroToastTimer);
  logroToastTimer = setTimeout(
    () => text.classList.remove("usr-toast--visible"),
    4000,
  );
}

async function cargarLogrosObtenidos() {
  logrosObtenidos = new Set();
  const usuario = getUsuario();
  if (!usuario?.id) return;
  const res = await fetch(`/api/usuario-logros/jugador/${usuario.id}`);
  if (!res.ok) return;
  const lista = await res.json();
  logrosObtenidos = new Set(lista.map((ul) => ul.logroId));
}

async function intentarObtenerLogro(logroId) {
  if (logrosObtenidos.has(logroId)) return null;
  const usuario = getUsuario();
  if (!usuario?.id) return null;
  const res = await fetch("/api/usuario-logros/obtener", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ jugadorId: usuario.id, logroId }),
  });
  if (res.status === 409) {
    logrosObtenidos.add(logroId);
    return null;
  }
  if (!res.ok) return null;
  const datos = await res.json();
  logrosObtenidos.add(logroId);
  sessionStorage.setItem(
    "usuario",
    JSON.stringify({ ...usuario, puntosLogro: datos.puntosLogro }),
  );
  const logro = datos.logro;
  if (logro?.logroNombre != null) {
    mostrarLogroObtenido(logro.logroNombre, logro.logroPuntos ?? 0);
  }
  return datos;
}

function dificultadActual() {
  if (nMinas === 10) return "FACIL";
  if (nMinas === 40) return "NORMAL";
  return "DIFICIL";
}

async function guardarPartida(victoria) {
  if (partidaGuardada) return;
  const usuario = getUsuario();
  if (!usuario?.id) return;

  const res = await fetch("/api/partidas", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      jugadorId: usuario.id,
      dificultad: dificultadActual(),
      tiempo: c,
      numeroMinas: nMinas,
      minasRestantes: victoria ? 0 : parseInt(contadorMinas.textContent, 10),
    }),
  });

  if (res.ok) partidaGuardada = true;
}

///////////////////////////////////////////////////////           CONTADOR          /////////////////////////////////////////////////////////
var contador = document.querySelector("#contador");
var c = 0;
let intervalo;

//////////////////////////////////////////////////////              JUEGO           ////////////////////////////////////
var tablero = document.querySelector("#tablero");
var contadorMinas = document.querySelector("#nMinas");
let casillaClickDerecho = null;

let nMinas = 40;
let xMax = 18;
let yMax = 14;

let arrayMinas = [];
let cercanas1 = [];
let cercanas2 = [];
let cercanas3 = [];
let cercanas4 = [];
let cercanas5 = [];
let cercanas6 = [];
let cercanas7 = [];
let cercanas8 = [];
let cercanas0 = [];

let marcadas = [];
let mComoDuda = [];
let tableroJugador = [];

let partidaFinalizada = false;
let partidaGuardada = false;

let cercanas = [
  cercanas1,
  cercanas2,
  cercanas3,
  cercanas4,
  cercanas5,
  cercanas6,
  cercanas7,
  cercanas8,
];

document.querySelector(".difficulty-grid").addEventListener("click", (e) => {
  if (e.target.classList.contains("difficulty-btn")) {
    switch (true) {
      case e.target.classList.contains("d1"):
        nMinas = 10;
        xMax = 10;
        yMax = 8;
        break;
      case e.target.classList.contains("d2"):
        nMinas = 40;
        xMax = 18;
        yMax = 14;
        break;
      case e.target.classList.contains("d3"):
        nMinas = 99;
        xMax = 30;
        yMax = 16;
        break;

      default:
        break;
    }
    limpiarTablero();
    crearTablero();
  }
});

crearTablero();

function crearTablero() {
  tablero.innerHTML = "";
  tablero.style.gridTemplateColumns = `repeat(${xMax}, 20px)`;
  for (let y = 0; y < yMax; y++) {
    for (let x = 0; x < xMax; x++) {
      let casilla = document.createElement("div");
      casilla.dataset.location = y + "-" + x;
      casilla.classList.add("casilla");
      tablero.append(casilla);
    }
  }
}

function crearMinas(location) {
  let locX = parseInt(location.split("-")[1]);
  let locY = parseInt(location.split("-")[0]);
  var inicio = [
    locY + "-" + locX,
    locY - 1 + "-" + (locX - 1),
    locY - 1 + "-" + (locX + 1),
    locY - 1 + "-" + locX,
    locY + "-" + (locX - 1),
    locY + "-" + (locX + 1),
    locY + 1 + "-" + locX,

    locY - 2 + "-" + locX,
    locY + "-" + (locX - 2),
    locY + "-" + (locX + 2),
    locY + 2 + "-" + locX,

    locY + 1 + "-" + (locX - 1),
    locY + 1 + "-" + (locX + 1),
  ];
  let minasPuestas = 0;

  while (minasPuestas < nMinas) {
    let ejeX = Math.floor(Math.random() * xMax);
    let ejeY = Math.floor(Math.random() * yMax);
    if (
      !arrayMinas.includes(ejeY + "-" + ejeX) &&
      !inicio.includes(ejeY + "-" + ejeX)
    ) {
      arrayMinas.push(ejeY + "-" + ejeX);
      minasPuestas++;
    }
  }
}

function comprobarMinas() {
  let casillas = tablero.querySelectorAll(".casilla");
  casillas.forEach((casilla) => {
    if (!arrayMinas.includes(casilla.dataset.location)) {
      // let minasCercanas = contarCercanas(casilla.dataset.location);
      let y = parseInt(casilla.dataset.location.split("-")[0]);
      let x = parseInt(casilla.dataset.location.split("-")[1]);
      let minasCercanas = contarCasillas(x, y, arrayMinas, () => 1);
      switch (true) {
        case minasCercanas == 0:
          cercanas0.push(casilla.dataset.location);
          break;
        case minasCercanas == 1:
          cercanas1.push(casilla.dataset.location);
          break;
        case minasCercanas == 2:
          cercanas2.push(casilla.dataset.location);
          break;
        case minasCercanas == 3:
          cercanas3.push(casilla.dataset.location);
          break;
        case minasCercanas == 4:
          cercanas4.push(casilla.dataset.location);
          break;
        case minasCercanas == 5:
          cercanas5.push(casilla.dataset.location);
          break;
        case minasCercanas == 6:
          cercanas6.push(casilla.dataset.location);
          break;
        case minasCercanas == 7:
          cercanas7.push(casilla.dataset.location);
          break;
        case minasCercanas == 8:
          cercanas8.push(casilla.dataset.location);
          break;

        default:
          break;
      }
    }
  });
}

////////////////////////////////////////////////////////////
function expandirJugador(location) {
  let espacioJugador = [location];
  let x, y;
  for (let index = 0; index < espacioJugador.length; index++) {
    y = parseInt(espacioJugador[index].split("-")[0]);
    x = parseInt(espacioJugador[index].split("-")[1]);

    // Pusheo todas las casillas sin minas adyacentes a la casilla[index] de espacioJugador, que aumenta dinámicamente
    // con las casillas pusheadas(con 0 minas adyacentes)
    contarCasillas(
      x,
      y,
      cercanas0,
      (array, aPushear) => {
        if (!array.includes(aPushear) && !tableroJugador.includes(aPushear)) {
          array.push(aPushear);
        }
      },
      espacioJugador,
    );
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////

  // Por cada espacio de jugador nuevo compruebo si alguna de sus casillas adyacentes
  // tiene minas adyacentes SIN que espacioJugador aumente de forma dinámica
  espacioJugador.forEach((nuevoEspacio) => {
    y = parseInt(nuevoEspacio.split("-")[0]);
    x = parseInt(nuevoEspacio.split("-")[1]);

    contarCasillas(
      x,
      y,
      cercanas,
      (array, aPushear) => {
        if (!array.includes(aPushear) && !tableroJugador.includes(aPushear)) {
          array.push(aPushear);
        }
      },
      espacioJugador,
    );
    contarCasillas(
      x,
      y,
      arrayMinas,
      (array, aPushear) => {
        if (
          !array.includes(aPushear) &&
          !marcadas.includes(aPushear) &&
          !tableroJugador.includes(aPushear)
        ) {
          array.push(aPushear);
        }
      },
      espacioJugador,
    );
  });

  // Por cada espacioJugador resultante se muestran las casillas que tienen minas adyancentes (o son minas) y que no estén marcadas
  espacioJugador.forEach((nuevoEspacio) => {
    if (
      !marcadas.includes(nuevoEspacio) &&
      !mComoDuda.includes(nuevoEspacio) &&
      !arrayMinas.includes(nuevoEspacio) &&
      !tableroJugador.includes(nuevoEspacio)
    ) {
      tableroJugador.push(nuevoEspacio);
    } else if (arrayMinas.includes(nuevoEspacio)) {
      finJuego(nuevoEspacio);
    }
    tablero
      .querySelector(`[data-location="${nuevoEspacio}"]`)
      .classList.add("usuario");
    if (
      tableroJugador.includes(nuevoEspacio) &&
      document.querySelector(`[data-location="${nuevoEspacio}"]`).textContent ==
        ""
    ) {
      if (!cercanas0.includes(nuevoEspacio)) {
        document.querySelector(
          `[data-location="${nuevoEspacio}"]`,
        ).textContent =
          cercanas.findIndex((cercana) => cercana.includes(nuevoEspacio)) + 1;

        document
          .querySelector(`[data-location="${nuevoEspacio}"]`)
          .classList.add(
            "num-" +
              (cercanas.findIndex((cercana) => cercana.includes(nuevoEspacio)) +
                1),
          );
        document
          .querySelector(`[data-location="${nuevoEspacio}"]`)
          .classList.add("revealed");
      } else {
        document.querySelector(
          `[data-location="${nuevoEspacio}"]`,
        ).textContent = " ";
        document
          .querySelector(`[data-location="${nuevoEspacio}"]`)
          .classList.add("revealed");
      }
    }
  });

  if (
    partidaFinalizada == false &&
    tableroJugador.length ==
      cercanas0.length +
        cercanas.reduce((acumulador, cercana) => acumulador + cercana.length, 0)
  ) {
    finJuego(true);
  }
}

limpiarTablero();

async function crearJuego(e) {
  let clickada = e.target;
  if (clickada.classList.contains("casilla")) {
    await cargarLogrosObtenidos();
    intervalo = setInterval(() => {
      contador.textContent = String(++c).padStart(3, "0");
    }, 1000);
    iniciarArrays();
    partidaFinalizada = false;
    partidaGuardada = false;
    crearMinas(clickada.dataset.location);
    comprobarMinas();
    expandirJugador(clickada.dataset.location);
    tablero.removeEventListener("click", crearJuego);
    tablero.addEventListener("mousedown", comprobarClick);
    tablero.addEventListener("click", clickEnCasillas);
    tablero.addEventListener("contextmenu", rClickEnCasillas);
  }
}

function comprobarClick(e4) {
  if (e4.button === 2) {
    if (e4.target.closest(".casilla")) {
      casillaClickDerecho = e4.target.closest(".casilla");
    } else {
      casillaClickDerecho = e4.target;
    }
  }
}

function clickEnCasillas(e2) {
  let clickada = e2.target;
  if (
    clickada.classList.contains("casilla") &&
    !clickada.classList.contains("bandera") &&
    !clickada.classList.contains("duda")
  ) {
    if (
      tableroJugador.includes(clickada.dataset.location) &&
      !cercanas0.includes(clickada.dataset.location)
    ) {
      y = parseInt(clickada.dataset.location.split("-")[0]);
      x = parseInt(clickada.dataset.location.split("-")[1]);
      if (
        cercanas.findIndex((cercana) =>
          cercana.includes(clickada.dataset.location),
        ) +
          1 ==
          contarCasillas(x, y, marcadas, () => 1) &&
        contarCasillas(x, y, mComoDuda, () => 1) == 0
      ) {
        expandirJugador(clickada.dataset.location);
      }
    } else if (cercanas0.includes(clickada.dataset.location)) {
      expandirJugador(clickada.dataset.location);
    } else if (arrayMinas.includes(clickada.dataset.location)) {
      finJuego(clickada.dataset.location);
      // return;
    } else if (
      cercanas.some((cercana) => cercana.includes(clickada.dataset.location))
    ) {
      tableroJugador.push(clickada.dataset.location);
      document
        .querySelector(`[data-location="${clickada.dataset.location}"]`)
        .classList.add("usuario");

      document.querySelector(
        `[data-location="${clickada.dataset.location}"]`,
      ).textContent =
        cercanas.findIndex((cercana) =>
          cercana.includes(clickada.dataset.location),
        ) + 1;
      document
        .querySelector(`[data-location="${clickada.dataset.location}"]`)
        .classList.add(
          "num-" +
            (cercanas.findIndex((cercana) =>
              cercana.includes(clickada.dataset.location),
            ) +
              1),
        );
      document
        .querySelector(`[data-location="${clickada.dataset.location}"]`)
        .classList.add("revealed");
    }

    if (
      partidaFinalizada == false &&
      tableroJugador.length ==
        cercanas0.length +
          cercanas.reduce(
            (acumulador, cercana) => acumulador + cercana.length,
            0,
          )
    ) {
      finJuego(true);
    }
  }
}

function rClickEnCasillas(e3) {
  e3.preventDefault();
  if (e3.target.closest(".casilla")) {
    e3 = e3.target.closest(".casilla");
  }
  if (e3 == casillaClickDerecho) {
    banderasPuestas = true;
    let clickada = e3;
    if (clickada.classList.contains("casilla")) {
      if (!tableroJugador.includes(clickada.dataset.location)) {
        if (
          !clickada.classList.contains("bandera") &&
          !clickada.classList.contains("duda")
        ) {
          clickada.classList.add("bandera");
          contadorMinas.textContent = parseInt(contadorMinas.textContent) - 1;
          marcadas.push(clickada.dataset.location);
          let banderaEnCasilla = document.createElement("img");
          banderaEnCasilla.src = "./img/flag.png";
          clickada.append(banderaEnCasilla);
        } else if (clickada.classList.contains("bandera")) {
          clickada.classList.remove("bandera");
          marcadas.splice(marcadas.indexOf(clickada.dataset.location), 1);
          clickada.classList.add("duda");
          mComoDuda.push(clickada.dataset.location);
          contadorMinas.textContent = parseInt(contadorMinas.textContent) + 1;
          clickada.querySelector("img").remove();
          clickada.textContent = "?";
        } else {
          clickada.classList.remove("duda");
          mComoDuda.splice(mComoDuda.indexOf(clickada.dataset.location), 1);
          clickada.textContent = "";
        }
      }
    }
  }
  casillaClickDerecho = null;
}

async function finJuego(parametro = false) {
  tablero.removeEventListener("mousedown", comprobarClick);
  tablero.removeEventListener("click", clickEnCasillas);
  tablero.removeEventListener("contextmenu", rClickEnCasillas);
  tablero.addEventListener("click", limpiarTablero, { once: true });
  if (parametro === true) {
    alert(
      "Tablero resuelto, has tardado " + contador.textContent + " segundos.",
    );
    if (contador.textContent < 30) {
      await intentarObtenerLogro(14);
    }
    if (banderasPuestas == false) {
      await intentarObtenerLogro(15);
    }
    switch (nMinas) {
      case 10:
        await intentarObtenerLogro(11);
        break;
      case 40:
        await intentarObtenerLogro(12);
        break;
      case 99:
        await intentarObtenerLogro(13);
        break;
    }
    await guardarPartida(true);
  } else if (parametro !== false) {
    document
      .querySelector(`[data-location="${parametro}"]`)
      .classList.add("mina");
    arrayMinas.forEach((minaLocation) => {
      document
        .querySelector(`[data-location="${minaLocation}"]`)
        .classList.add("mina");
      document
        .querySelector(`[data-location="${minaLocation}"]`)
        .classList.remove("bandera");
      document
        .querySelector(`[data-location="${minaLocation}"]`)
        .classList.remove("duda");
      document
        .querySelector(`[data-location="${minaLocation}"]`)
        .classList.add("revealed");
      if (
        document
          .querySelector(`[data-location="${minaLocation}"]`)
          .querySelector("img")
      ) {
        document
          .querySelector(`[data-location="${minaLocation}"]`)
          .querySelector("img")
          .remove();
      }
      document.querySelector(`[data-location="${minaLocation}"]`).textContent =
        "";
      let minaImg = document.createElement("img");
      minaImg.src = "./img/mine.png";
      document
        .querySelector(`[data-location="${minaLocation}"]`)
        .append(minaImg);
    });
    await intentarObtenerLogro(10);
    await guardarPartida(false);
  }

  clearInterval(intervalo);
  intervalo = null;
  partidaFinalizada = true;
}

function limpiarTablero() {
  if (partidaFinalizada != true) {
    clearInterval(intervalo);
    intervalo = null;
    partidaFinalizada = true;
    iniciarArrays();
  }
  c = 0;
  partidaGuardada = false;
  banderasPuestas = false;
  contador.textContent = String(c).padStart(3, "0");
  contadorMinas.textContent = nMinas;
  let casillas = document.querySelectorAll(".casilla");
  casillas.forEach((casilla) => {
    casilla.textContent = "";
    casilla.classList.remove("usuario");
    casilla.classList.remove("mina");
    casilla.classList.remove("bandera");
    casilla.classList.remove("duda");

    casilla.classList.remove("revealed");
    for (let index = 1; index <= 6; index++) {
      casilla.classList.remove("num-" + index);
    }
  });

  tablero.addEventListener("click", crearJuego);
}
////////////////////////////////////////////////
function ponerBandera(location) {
  marcadas.push(location);
  tablero
    .querySelector(`[data-location = ${location}]`)
    .classList.add("bandera");
}

///////////////////////////////////////////////////////////////////////
function iniciarArrays() {
  arrayMinas = [];
  cercanas1 = [];
  cercanas2 = [];
  cercanas3 = [];
  cercanas4 = [];
  cercanas5 = [];
  cercanas6 = [];
  cercanas7 = [];
  cercanas8 = [];
  cercanas0 = [];
  marcadas = [];
  mComoDuda = [];
  tableroJugador = [];

  cercanas = [
    cercanas1,
    cercanas2,
    cercanas3,
    cercanas4,
    cercanas5,
    cercanas6,
    cercanas7,
    cercanas8,
  ];
}
function contarCasillas(
  x,
  y,
  aComparar,
  funcionARealizar,
  arrayObjetivo = null,
) {
  let auxiliar = 0;

  if (x - 1 >= 0) {
    if (
      aComparar.includes(y + "-" + (x - 1)) ||
      (aComparar == cercanas &&
        aComparar.some((a) => a.includes(y + "-" + (x - 1))))
    ) {
      auxiliar += funcionARealizar(arrayObjetivo, y + "-" + (x - 1));
    }
    if (y - 1 >= 0) {
      if (
        aComparar.includes(y - 1 + "-" + (x - 1)) ||
        (aComparar == cercanas &&
          aComparar.some((a) => a.includes(y - 1 + "-" + (x - 1))))
      ) {
        auxiliar += funcionARealizar(arrayObjetivo, y - 1 + "-" + (x - 1));
      }
    }
    if (y + 1 < yMax) {
      if (
        aComparar.includes(y + 1 + "-" + (x - 1)) ||
        (aComparar == cercanas &&
          aComparar.some((a) => a.includes(y + 1 + "-" + (x - 1))))
      ) {
        auxiliar += funcionARealizar(arrayObjetivo, y + 1 + "-" + (x - 1));
      }
    }
  }

  if (x + 1 < xMax) {
    if (
      aComparar.includes(y + "-" + (x + 1)) ||
      (aComparar == cercanas &&
        aComparar.some((a) => a.includes(y + "-" + (x + 1))))
    ) {
      auxiliar += funcionARealizar(arrayObjetivo, y + "-" + (x + 1));
    }
    if (y - 1 >= 0) {
      if (
        aComparar.includes(y - 1 + "-" + (x + 1)) ||
        (aComparar == cercanas &&
          aComparar.some((a) => a.includes(y - 1 + "-" + (x + 1))))
      ) {
        auxiliar += funcionARealizar(arrayObjetivo, y - 1 + "-" + (x + 1));
      }
    }
    if (y + 1 < yMax) {
      if (
        aComparar.includes(y + 1 + "-" + (x + 1)) ||
        (aComparar == cercanas &&
          aComparar.some((a) => a.includes(y + 1 + "-" + (x + 1))))
      ) {
        auxiliar += funcionARealizar(arrayObjetivo, y + 1 + "-" + (x + 1));
      }
    }
  }
  if (y - 1 >= 0) {
    if (
      aComparar.includes(y - 1 + "-" + x) ||
      (aComparar == cercanas &&
        aComparar.some((a) => a.includes(y - 1 + "-" + x)))
    ) {
      auxiliar += funcionARealizar(arrayObjetivo, y - 1 + "-" + x);
    }
  }
  if (y + 1 < yMax) {
    if (
      aComparar.includes(y + 1 + "-" + x) ||
      (aComparar == cercanas &&
        aComparar.some((a) => a.includes(y + 1 + "-" + x)))
    ) {
      auxiliar += funcionARealizar(arrayObjetivo, y + 1 + "-" + x);
    }
  }
  return auxiliar;
}

document.querySelector(".reset-btn").addEventListener("click", limpiarTablero);
