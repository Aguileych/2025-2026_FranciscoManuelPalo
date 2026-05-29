function requiereLogin() {
    const usuario = JSON.parse(sessionStorage.getItem('usuario'));
    if (!usuario) {
        window.location.href = 'minesweeper.html';
    }
}

function getUsuario() {
    return JSON.parse(sessionStorage.getItem('usuario'));
}

function toggleDropdown(dropdownId) {
    document.querySelectorAll(".dropdown-content").forEach((dropdown) => {
        if (dropdown.id !== dropdownId) dropdown.classList.remove("show");
    });
    document.getElementById(dropdownId).classList.toggle("show");
}

function switchForm(formType) {
    const loginForm    = document.getElementById("loginForm");
    const registerForm = document.getElementById("registerForm");
    if (formType === "register") {
        loginForm.classList.remove("active");
        registerForm.classList.add("active");
    } else {
        registerForm.classList.remove("active");
        loginForm.classList.add("active");
    }
}

window.addEventListener("click", function (event) {
    if (!event.target.closest(".dropdown-container")) {
        document.querySelectorAll(".dropdown-content").forEach((dropdown) => {
            dropdown.classList.remove("show");
        });
    }
});

document.querySelectorAll(".dropdown-content").forEach((dropdown) => {
    dropdown.addEventListener("click", function (event) {
        event.stopPropagation();
    });
});