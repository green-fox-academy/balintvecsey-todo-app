
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Bálint on 2017. 04. 06..
 */
public class App {

  public static void main(String[] args) {
    ArgumentHandler argument = new ArgumentHandler(args);
    argument.printUsage();
  }
}
