# Endpoints del Proyecto Pokemon VGC

## Jugador
- `GET /api/jugadores`  
  → Devuelve una lista de todos los jugadores registrados.
- `GET /api/jugadores/{id}`  
  → Devuelve los datos de un jugador específico por su ID.
- `GET /api/jugadores/{id}/equipo`  
  → Devuelve el equipo al que pertenece el jugador.
- `POST /api/jugadores`  
  → Crea un nuevo jugador. Requiere cuerpo en JSON con: `nombre`, `nacionalidad`, `arquetipoFavorito` y opcional `equipoId`.
- `PUT /api/jugadores/{id}`  
  → Actualiza los datos de un jugador existente.
- `DELETE /api/jugadores/{id}`  
  → Elimina un jugador por su ID.

## Equipo
- `GET /api/equipos`  
  → Devuelve una lista de todos los equipos.
- `GET /api/equipos/{id}`  
  → Devuelve los datos de un equipo específico.
- `GET /api/equipos/{id}/jugadores`  
  → Devuelve la lista de jugadores que pertenecen a ese equipo.
- `POST /api/equipos`  
  → Crea un nuevo equipo. Requiere `nombre` y `pais` en el cuerpo JSON.
- `PUT /api/equipos/{id}`  
  → Actualiza un equipo existente.
- `DELETE /api/equipos/{id}`  
  → Elimina un equipo (solo si no tiene jugadores asociados, por integridad referencial).

## Torneo
- `GET /api/torneos`  
  → Lista todos los torneos.
- `GET /api/torneos/{id}`  
  → Obtiene los detalles de un torneo.
- `GET /api/torneos/{id}/participantes`  
  → Devuelve la lista de jugadores inscritos en el torneo.
- `GET /api/torneos/{id}/ranking`  
  → **(Información calculada)** Devuelve los resultados del torneo ordenados por posición final (mejor a peor).
- `POST /api/torneos`  
  → Crea un nuevo torneo. Requiere `nombre`, `lugar`, `tipo` y `maxJugadores`.
- `PUT /api/torneos/{id}`  
  → Actualiza un torneo existente.
- `DELETE /api/torneos/{id}`  
  → Elimina un torneo.

> Todos los endpoints devuelven respuestas en formato JSON.
> Los códigos de estado HTTP son:  
> - `200 OK` (éxito en lectura/actualización),  
> - `201 Created` (creación exitosa),  
> - `204 No Content` (eliminación exitosa),  
> - `404 Not Found` (recurso no encontrado).