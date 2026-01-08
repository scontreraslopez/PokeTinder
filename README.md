# Prompt para Scaffold PokeTinder

Quiero que generes un proyecto Android completo en Kotlin usando Jetpack Compose, arquitectura MVVM y Navigation Compose. El proyecto se llama “PokeTinder”.
El starting code NO debe incluir arquitectura MVVM ni navegación. Eso lo implementaremos nosotros. En su lugar estarán construidas las pantallas sin conectar.
Para el tema de la interactividad tirará de state hoisting y saveables internos, no hace falta que funcione bien, simplemente que sea una base para de ahí construir manualmente la APP bien.

## Objetivo de la app
Es una mini‑app con dos pantallas principales:
1. Pantalla de “Encuentros” (pantalla inicial)
2. Pantalla de “Mis capturas”

La app simula un minijuego tipo Tinder pero con Pokémon.

## Reglas del juego
- Hay un pool fijo de 10 Pokémon (mock data, con nombre e imagen).
- En cada encuentro aparece un Pokémon aleatorio del pool.
- El usuario tiene:
    - 5 Pokéballs (swipe derecha = capturar)
    - 2 Huidas (swipe izquierda = huir / reroll)
- Cuando captura, el Pokémon se añade a la lista de “Mis capturas”.
- Cuando huye, se consume una huida y aparece otro Pokémon aleatorio.
- Si se acaban las Pokéballs o las Huidas, la pantalla debe mostrar un mensaje de que no quedan recursos.
- No debe repetirse el mismo Pokémon dos veces en capturas.
- La lógica del juego debe estar en un ViewModel.

## Pantalla 1: Encuentros
- Muestra:
    - El Pokémon actual (nombre + imagen).
    - Contador de Pokéballs restantes.
    - Contador de Huidas restantes.
    - Botón para navegar a “Mis capturas”.
- Permite:
    - Swipe derecha → capturar (si quedan Pokéballs).
    - Swipe izquierda → huir (si quedan Huidas).
    - Alternativa: botones “Capturar” y “Huir” por si no quieres implementar gestos.

## Pantalla 2: Mis capturas
- Lista simple (LazyColumn) con los Pokémon capturados.
- Botón para volver atrás.

## Arquitectura
- MVVM con un único ViewModel compartido entre pantallas.
- Repository con lista mock de 10 Pokémon. Típico singleton.
- Navegación con Navigation Compose.
- Estados expuestos con StateFlow.
- UI en Jetpack Compose.

## Qué quiero generado
- Estructura completa del proyecto.
- Repository con datos mock. Usa placeholders y ya meto yo los res apropiados.
- Dos pantallas funcionales.
- Código Compose para mostrar la carta del Pokémon.
- Código para los contadores y botones.
- Código para la lista de capturas.

No uses Firebase, ni red, ni Room. Todo mock y local.

Genera el proyecto base con todos los archivos necesarios.