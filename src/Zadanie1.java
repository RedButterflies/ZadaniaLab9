/*public class Zadanie1 {
*/
import java.io.File;

public class Zadanie1 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\szyns\\IdeaProjects\\Pliki\\src\\lotto.txt");
        File file1= new File("C:\\Users\\szyns\\Desktop\\metrologia");
        funkcja(file);
        funkcja(file1);
    }
    public static void funkcja(File file)
    {

        if(file.isFile())
        {
            System.out.println("Sciezka jest plikiem");
        }
        else if(file.isDirectory())
        {
            System.out.println("Sciezka jest katalogiem");
        }
    }
}
