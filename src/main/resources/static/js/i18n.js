let resolverTraducciones;
const traduccionesPromesa = new Promise((resolve) => {
  resolverTraducciones = resolve;
});

async function cargarIdioma(idioma) {
  const res = await fetch(`./js/i18n/${idioma}.json`);
  const data = await res.json();
  sessionStorage.setItem("idioma", idioma);
  sessionStorage.setItem("traducciones", JSON.stringify(data));
  if (idioma == "es") {
    document.querySelector("#langFlag").src = "img/spanish.png";
  } else {
    document.querySelector("#langFlag").src = "img/unionjack.webp";
  }
  aplicarTraducciones(data);
  resolverTraducciones();
}

function t(clave) {
  const traducciones = JSON.parse(
    sessionStorage.getItem("traducciones") || "{}",
  );
  const partes = clave.split(".");
  let valor = traducciones;
  for (const parte of partes) {
    valor = valor?.[parte];
  }
  return valor ?? clave;
}

function tError(clave) {
  const traducido = t("errors." + clave);
  return traducido !== "errors." + clave ? traducido : clave;
}

function aplicarTraducciones(traducciones) {
  document.querySelectorAll("[data-i18n]").forEach((el) => {
    const valor = t(el.getAttribute("data-i18n"));
    if (valor) el.textContent = valor;
  });

  document.querySelectorAll("[data-i18n-placeholder]").forEach((el) => {
    const valor = t(el.getAttribute("data-i18n-placeholder"));
    if (valor) el.placeholder = valor;
  });

  if (traducciones.css) {
    Object.entries(traducciones.css).forEach(([variable, valor]) => {
      document.documentElement.style.setProperty(variable, valor);
    });
  }
}

async function cambiarIdioma() {
  const idiomaActual = sessionStorage.getItem("idioma") || "en";
  const nuevoIdioma = idiomaActual === "en" ? "es" : "en";

  await cargarIdioma(nuevoIdioma);
}

async function esperarTraducciones() {
  await traduccionesPromesa;
}

function tOk(clave) {
  const traducido = t("ok." + clave);
  return traducido !== "ok." + clave ? traducido : clave;
}

window.addEventListener("DOMContentLoaded", async () => {
  const idiomaGuardado = sessionStorage.getItem("idioma") || "es";
  await cargarIdioma(idiomaGuardado);
});
