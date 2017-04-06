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
    if (Arrays.toString(args).contains("-a")) {
      String task = Arrays.toString(args).substring(5, (Arrays.toString(args).length() - 1));
      try {
        Path path = Paths.get("../files/todolist.txt");
        List<String> lines = Files.readAllLines(path);
        lines.add(task);
        Files.write(path, lines);
      } catch (Exception e) {
        System.out.println("Error: " + e.getClass());
      }
    }
  }
}
