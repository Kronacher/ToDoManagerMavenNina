
# Pflichtenheft – To-Do-Listen-Manager (Konsole)

## Systemarchitektur
Drei Schichten:
- UI (`ui.ConsoleUI`) – Interaktion über Konsole
- Service (`service.ToDoService`) – Regeln/Validierung/Orchestrierung
- Repository (`repository.FileToDoRepository`) – JSON-Persistenz via Gson

## Datenmodell
`model.ToDo { id:int, description:String, dueDate:String|null, completed:boolean }`

## Schnittstellen
- `ToDoRepository`:
  - `void save(ToDo)` – Upsert (neue Einträge werden erstellt, bestehende Einträge aktualisiert)
  - `Optional<ToDo> findById(int)`
  - `List<ToDo> findAll()`
  - `void deleteById(int)`
- `ToDoService`:
  - `void addToDo(String description, String dueDate)`
  - `List<ToDo> listToDos()`
  - `void completeToDo(int id)`
  - `void deleteToDo(int id)`

## Geschäftsregeln
- Beschreibung darf nicht leer sein
- Fälligkeitsdatum: leer oder ISO-Format `yyyy-mm-dd`
- IDs werden fortlaufend vergeben (max(existingId)+1)

## Persistenz
- Datei `data/toDos.json` (UTF-8)
- Format: JSON‑Array von `ToDo`-Objekten

## Testfälle (Auszug)
- **TC‑01**: Add → List → JSON enthält Aufgabe
- **TC‑02**: Complete → List zeigt Status „erledigt“
- **TC‑03**: Delete → Aufgabe nicht mehr vorhanden
- **TC‑04**: Add (leere Beschreibung) → Fehler
- **TC‑05**: Add (Datum falsch) → Fehler
