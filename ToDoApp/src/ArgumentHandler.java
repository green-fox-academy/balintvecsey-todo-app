import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bálint on 2017. 04. 06..
 */
public class ArgumentHandler {

  String[] args;

  public ArgumentHandler(String[] args) {
    this.args = args;
  }

  public void arguments() {
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
    } else if (Arrays.toString(args).contains("-l")) {
      List<String> content = new ArrayList<>();
      content.add("Walk the dog");
      content.add("Buy milk");
      content.add("Do homework");
      int num = 0;

      try {
        Path path = Paths.get("../files/todolist.txt");
        Files.write(path, content);
        List<String> lines = Files.readAllLines(path);

        for (String line : lines) {
          num++;
          System.out.println(num + " - " + line);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
