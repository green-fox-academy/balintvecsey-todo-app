/**
 * Created by Bálint on 2017. 04. 06..
 */
public class App {

  public static void main(String[] args) {
    ToDoList myToDoList = new ToDoList(args);

    myToDoList.printUsage();
    myToDoList.showList();
    myToDoList.addTask();
  }
}
