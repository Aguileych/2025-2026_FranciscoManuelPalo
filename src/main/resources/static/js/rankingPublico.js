async function cargarPublico(dificultad) {
    let res;
  switch (true) {
    case dificultad == "easy":
       res = await fetch("api/partidas/dificultad/facil");

      break;

    case dificultad == "normal":
       res = await fetch("api/partidas/dificultad/normal");

      break;

    case dificultad == "hard":
       res = await fetch("api/partidas/dificultad/dificil");

      break;

    default:
      break;
  }




  const datos = await res.json();

  const scoreList = document.getElementById("scoreList");

  scoreList.innerHTML = "";

  // Agregar nuevos scores
  datos.forEach((score) => {
    const scoreItem = document.createElement("div");
    scoreItem.className = "score-item";
    scoreItem.innerHTML = `<span>${score.jugadorUsername}</span><span>${score.tiempo}</span>`;
    scoreList.appendChild(scoreItem);
  });

  // Actualizar botones activos
  document.querySelectorAll(".score-filter-btn").forEach((btn) => {
    btn.classList.remove("active");
  });
  if (dificultad== "easy") {
    document.querySelector(".score-filter-btn").classList.add("active");
  } else {
    document.querySelector("#"+dificultad).classList.add("active");
  }

}


