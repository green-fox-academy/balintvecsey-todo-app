
import java.io.IOException;
import java.lang.reflect.Array;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bálint on 2017. 04. 06..
 */
public class App {

  public static void main(String[] args) {
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
