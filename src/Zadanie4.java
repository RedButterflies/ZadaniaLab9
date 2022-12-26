/*4. Napisz program Java, aby uzyskać rozmiar pliku w bajtach, kb, mb.*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Zadanie4 {
    public static void main(String[] args) throws IOException {
        rozmiarPliku();
    }
    public static void rozmiarPliku() throws IOException {
        Path path = Paths.get("C:\\Users\\szyns\\IdeaProjects\\Pliki\\src\\lotto.txt");
        long sizeBytes = Files.size(path);
        double sizeMegaBytes = (double)Files.size(path)/1000000;
        double sizeKiloBytes = (double)Files.size(path)/1000;
        System.out.println("Rozmiar pliku w bajtach: "+sizeBytes);
        System.out.println("Rozmiar pliku w megabajtach: "+sizeMegaBytes);
        System.out.println("Rozmiar pliku w kilobajtach: "+sizeKiloBytes);


    }

}
