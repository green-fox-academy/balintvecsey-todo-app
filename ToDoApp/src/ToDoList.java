import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bálint on 2017. 04. 06..
 */
public class ToDoList {
  String[] args;

  public ToDoList(String[] args) {
    this.args = args;
  }

  public void printUsage() {
    if (args.length == 0) {
      try {
        Path path = Paths.get("../files/usage.txt");
        List<String> lines = Files.readAllLines(path);

        for (String usage : lines) {
          System.out.println(usage);
        }
      } catch (Exception e) {
        System.out.println("Error: " + e.getClass());
      }
    }
  }

  public void showList () {
    if (args[0].contains("-l")) {
      try {
        Path path = Paths.get("../files/todolist.txt");
        List<String> lines = Files.readAllLines(path);
        int num = 0;

        if (lines.isEmpty()) {
          System.out.println("No todos for today! :)");
        } else {
          for (String line : lines) {
            num++;
            System.out.println(num + " - " + line);
          }
        }
      } catch (Exception e) {
        System.out.println("Error: " + e.getClass());
      }
    }
  }

  public void addTask() {
    if (args[0].contains("-a")) {
      String task = args[1];
      String undone = "[ ] ";
      try {
        Path path = Paths.get("../files/todolist.txt");
        List<String> lines = Files.readAllLines(path);

        lines.add(undone + task);
        Files.write(path, lines);
      } catch (Exception e) {
        System.out.println("Error: " + e.getClass());
      }
    }
  }

  public void removeTask() {
    if (args[0].contains("-r")) {
      try {
        Path path = Paths.get("../files/todolist.txt");
        List<String> lines = Files.readAllLines(path);

        lines.remove(Integer.parseInt(args[1]) - 1);
        Files.write(path, lines);
      } catch (Exception e) {
        System.out.println("Error: " + e.getClass());
      }
    }
  }

  public void checkTask() {
    if (args[0].contains("-c")) {
      try {
        Path path = Paths.get("../files/todolist.txt");
        List<String> lines = Files.readAllLines(path);
        String task = lines.get(Integer.parseInt(args[1]) - 1);

        lines.set(Integer.parseInt(args[1]) - 1, "[x] " + task.substring(4));
        Files.write(path, lines);
      } catch (Exception e) {
        System.out.println("Error: " + e.getClass());
      }
    }
  }
}
