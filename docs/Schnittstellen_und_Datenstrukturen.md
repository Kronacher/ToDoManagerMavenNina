
# Definition von Schnittstellen und Datenstrukturen

## Schnittstellen
### `ToDoRepository`
CRUD‑ähnliche Methoden zur Persistenz.

### `ToDoService`
Geschäftsvorgänge „Add/List/Complete/Delete“ mit Validierung.

## Datenstrukturen
### `ToDo`
- `id:int` – eindeutige ID
- `description:String` – Pflichtfeld
- `dueDate:String|null` – optionales Datum im Format `yyyy-mm-dd`
- `completed:boolean` – Status
