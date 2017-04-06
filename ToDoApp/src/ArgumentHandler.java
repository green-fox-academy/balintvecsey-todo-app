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
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
