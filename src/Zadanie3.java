/*3. Napisz program w Javie, który:
        a. doda tekst do istniejącego pliku
        b. zastąpi istniejący tekst*/
import java.io.*;

public class Zadanie3 {
    public static void main(String[] args) throws IOException {
        dopisz();
        wyswietl();
        zastap();
        System.out.println("\n");
        wyswietl();
        dopisz();
        System.out.println("\n");
        wyswietl();
    }
    public static void dopisz() throws IOException {
    File file = new File("C:\\Users\\szyns\\IdeaProjects\\Pliki\\src\\Poem.txt");
    FileWriter fw= new FileWriter(file,true);
    BufferedWriter bw = new BufferedWriter(fw);
    String line = "\nMay you fly high.";
    bw.append(line);
    bw.close();
    fw.close();
    }
    public static void zastap() throws IOException {
        File file = new File("C:\\Users\\szyns\\IdeaProjects\\Pliki\\src\\Poem.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw= new BufferedWriter(fw);
        String line = """
                Duck, duck, duck,

                You bend your neck towards the sky and sing.

                Your white feathers float on the emerald water,

                Your red feet push the clear waves.""";
        bw.write(line);
        bw.close();
        fw.close();

    }
    public static void wyswietl() throws IOException {
        File file = new File("C:\\Users\\szyns\\IdeaProjects\\Pliki\\src\\Poem.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line=br.readLine())!=null)
        {
            System.out.println(line);
        }
        br.close();
        fr.close();

    }
}
