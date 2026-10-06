package app;

import model.ToDo;
import repository.FileToDoRepository;
import repository.ToDoRepository;
import service.ToDoService;
import ui.ConsoleUI;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			//repoTest();
			ToDoRepository repo = new FileToDoRepository(Path.of("todos.json"));
			ToDoService service = new ToDoService(repo);
			ConsoleUI ui = new ConsoleUI(service);

			ui.run();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}


	}

	private static void repoTest() throws IOException
	{
		ToDoRepository repo = new FileToDoRepository(Path.of("todos.json"));

		ToDo t1 = new ToDo(1, "Erste ToDo, ganz wichtig!", "Morgen", false);

		// Repo Test 1: Leere Liste abfragen
		List<ToDo> liste = repo.findAll();
		liste.forEach(System.out::println);
		System.out.println(liste.size());
		System.out.println(liste.getClass().getName());

		// Repo Test 2: Fehlende ID abfragen
		System.out.println(repo.findById(1).isPresent());

		// Repo Test 3: To-Do hinzufügen
		repo.save(t1);
		System.out.println(repo.findById(1).isPresent());
		liste = repo.findAll();
		liste.forEach(System.out::println);

		// Repo Test 4: Completed auf true setzen
		t1.setCompleted(true);
		repo.save(t1);
		System.out.println(repo.findById(1).get());

		// Repo Test 5: To-Do löschen
		repo.deleteById(1);
		System.out.println(repo.findById(1).isPresent());
	}
}
