import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Bálint on 2017. 04. 06..
 */
public class ArgumentHandler {
  String[] args;

  public ArgumentHandler(String[] args){
    this.args = args;
  }

  public void printUsage() {
    if (args.length == 0){
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
}
