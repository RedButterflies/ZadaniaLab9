/*Napisz program w Javie, który pobierze czas ostatniej modyfikacji pliku.
*/
import java.io.File;
import java.util.Date;

public class Zadanie2 {
    public static void main(String[] args) {
        funkcja();
    }
    public static void funkcja()
    {
        File file = new File("C:\\Users\\szyns\\IdeaProjects\\Pliki\\src\\lotto.txt");
        System.out.println("Long: "+file.lastModified());
        Date date = new Date(file.lastModified());
        System.out.println("Date format: "+date);

    }
}
