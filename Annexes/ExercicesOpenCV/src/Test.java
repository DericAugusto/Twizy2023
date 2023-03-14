import java.nio.file.Paths;

public class Test {
  public static void main(String[] args) {

    String currentDir = System.getProperty("user.dir");
    //String path = Paths.get(currentDir).getParent().toString();

    System.out.println("\nMy current path is : \n\n");
    System.out.println(currentDir + "\\images\\opencv.png");
  }

}
