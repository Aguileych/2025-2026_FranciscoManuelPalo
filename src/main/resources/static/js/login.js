async function login() {
  const email = document.getElementById("loginEmail").value.trim();
  const password = document.getElementById("loginPassword").value;
  const errorEl = document.getElementById("loginError");

  if (!email || !password) {
    errorEl.textContent = `${t("registro.faltaCampos")}`;

    errorEl.style.display = "block";
    return;
  }

  const res = await fetch("/api/auth/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email, password }),
  });

  const datos = await res.json();

  if (!res.ok) {
    errorEl.textContent = t(datos.error);
    errorEl.style.display = "block";
    return;
  }

  sessionStorage.setItem("usuario", JSON.stringify(datos));
  const resUC = await fetch(`/api/usuario-cosmeticos/jugador/${datos.id}`);
  const cosmeticosUC = await resUC.json();
  const temaEquipado =
    cosmeticosUC.find((uc) => uc.equipado)?.cosmeticoEstilo ??
    "theme-classic.css";

  const usuarioConTema = { ...datos, temaEquipado };
  sessionStorage.setItem("usuario", JSON.stringify(usuarioConTema));
  actualizarHeaderUsuario(usuarioConTema);
  errorEl.style.display = "none";
  document.getElementById("theme-stylesheet").href =
    `./css/${usuarioConTema.temaEquipado}`;
  cargarTemas();

  document.getElementById("loginDropdown").classList.remove("show");
}

async function registro() {
  const email = document.getElementById("regEmail").value.trim();
  const username = document.getElementById("regUsername").value.trim();
  const password = document.getElementById("regPassword").value;
  const errorEl = document.getElementById("regError");

  if (!email || !username || !password) {
    errorEl.textContent = `${t("registro.faltaCampos")}`;
    errorEl.style.display = "block";
    return;
  }

  const res = await fetch("/api/auth/registro", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email, username, password }),
  });
  const datos = await res.json();

  if (!res.ok) {
    errorEl.textContent = t(datos.error);
    errorEl.style.display = "block";
    return;
  }
  // Registro exitoso → cambia al formulario de login
  errorEl.style.display = "none";
  switchForm("login");
  document.getElementById("loginEmail").value = email;
  document.getElementById("loginError").textContent = t("registro.creada");
  document.getElementById("loginError").style.color = "green";
  document.getElementById("loginError").style.display = "block";
}

function logout() {
  sessionStorage.removeItem("usuario");

  document.getElementById("theme-stylesheet").href = "./css/theme-classic.css";
  window.location.href = "minesweeper.html";
}

// Actualiza el botón del header según si hay sesión o no
function actualizarHeaderUsuario(usuario) {
  const btnText = document.getElementById("loginBtnText");
  const loginForm = document.getElementById("loginForm");
  const registerForm = document.getElementById("registerForm");
  const sessionPanel = document.getElementById("sessionPanel");
  const sessionName = document.getElementById("sessionUsername");

  if (usuario) {
    // Hay sesión — muestra panel de logout
    btnText.dataset.i18n = "";
    btnText.textContent = usuario.username;
    loginForm.style.display = "none";
    registerForm.style.display = "none";
    sessionPanel.style.display = "block";
    sessionName.textContent = `${usuario.username}`;
  } else {
    // Sin sesión — muestra formulario de login
    btnText.dataset.i18n = "header.login";
    btnText.textContent = "Login";
    loginForm.style.display = "";
    registerForm.style.display = "none";
    sessionPanel.style.display = "none";
    loginForm.classList.add("active");
  }
}

window.addEventListener("DOMContentLoaded", () => {
  const usuario = getUsuario();
  if (usuario) actualizarHeaderUsuario(usuario);
});
