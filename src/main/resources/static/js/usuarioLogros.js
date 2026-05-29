
async function obtenerLogro(jugadorId, logroId) {
  const res = await fetch("/api/usuario-logros/obtener", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ jugadorId, logroId }),
  });
  const datos = await res.json();
  if (!res.ok) throw new Error(datos.error ?? "Error al obtener logro");
  return datos;
}

async function listarLogrosJugador(jugadorId) {
  const res = await fetch(`/api/usuario-logros/jugador/${jugadorId}`);
  if (!res.ok) throw new Error("Error al listar logros del jugador");
  return res.json();
}
