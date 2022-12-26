/*5. Napisz program w Javie zliczający wystąpienia 6 najczęściej i 6 najrzadziej występujących
liczb z pliku lotto.txt. Wyniki zapisz do oddzielnego pliku wyniki.txt.
*Jeśli powtórzyły się wyniki lotto, wyświetl daty kiedy to wystąpiło.*/
import java.io.*;
import java.util.*;

public class Zadanie5 {
    public static void main(String[] args) throws IOException {
        funkcja();
    }

    public static void funkcja() throws IOException {
        ArrayList<String[]> split = new ArrayList<>();
        ArrayList<String> liczby = new ArrayList<>();
        ArrayList<String[]> wszystkieLiczby = new ArrayList<>();
        List<String> wszystkieLiczbyA = new ArrayList<>();
        ArrayList<String> daty = new ArrayList<>();
        File file = new File("C:\\Users\\szyns\\IdeaProjects\\Pliki\\src\\lotto.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            split.add((line.split(" ")));
        }
        for (String[] x : split) {
            liczby.add(x[2]);
        }
        for (String[] x : split) {
            daty.add(x[1]);
        }
        for (String a : liczby) {
            System.out.println(a);
        }
        for (String a : liczby) {
            wszystkieLiczby.add(a.split(","));
        }
        for(String [] b : wszystkieLiczby)
        {
            wszystkieLiczbyA.addAll(Arrays.asList(b));
        }
        System.out.println(wszystkieLiczbyA);
        Collections.sort(wszystkieLiczbyA);
        System.out.println(wszystkieLiczbyA);


        Hashtable<String,Integer>liczbaAndCount = new Hashtable<>();

        for(String liczba: wszystkieLiczbyA)
        {
            Integer count = liczbaAndCount.get(liczba);
            if(count ==null)
            {
                liczbaAndCount.put(liczba,1);
            }
            else
            {
                liczbaAndCount.put(liczba,++count);
            }
        }
        List<Integer> table;
        table=liczbaAndCount.values().stream().sorted().toList();
        List<Integer> najczesciej=new ArrayList<>();
        List<Integer> najrzadziej=new ArrayList<>();
        for(int i=0;i<6;i++)
        {
            System.out.println((table.get(i)));
            najrzadziej.add(table.get(i));

        }
        System.out.println();
        table=liczbaAndCount.values().stream().sorted(Comparator.reverseOrder()).toList();
        for(int i=0;i<6;i++)
        {
            System.out.println((table.get(i)));
            najczesciej.add(table.get(i));

        }
        Collections.sort(najczesciej);
        Collections.sort(najrzadziej);

        System.out.println();
        System.out.println();
        System.out.println();
        HashMap<String,String>mapa= new HashMap<>();
        for(int i=0;i<liczby.size();i++)
        {
            mapa.put(liczby.get(i),daty.get(i));

        }
        File wyniki= new File("wyniki2.txt");
        FileWriter fileWriter = new FileWriter(wyniki,true);
        BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
        String linia;

        System.out.println("Wyniki lotto powtorzyly sie w datach: ");
        linia="Wyniki lotto powtorzyly sie w datach: ";
        bufferedWriter.write(linia);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        ArrayList<Integer> key = new ArrayList<>();
        for(int i = 0; i < liczby.size(); i++)
        {
           if(mapa.containsKey(liczby.get(i)) && !mapa.containsValue(daty.get(i)))
           {
               System.out.println(daty.get(i));
               linia= daty.get(i);
               bufferedWriter.write(linia);
               bufferedWriter.newLine();
               bufferedWriter.flush();
               key.add(i);

           }
        }
        System.out.println(mapa.get(liczby.get(key.get(0))));
        linia=mapa.get(liczby.get(key.get(0)));
        bufferedWriter.write(linia);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("6 liczb, ktore sie powtorzyly najrzadziej: ");
        linia ="6 liczb, ktore sie powtorzyly najrzadziej: ";
        bufferedWriter.write(linia);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        Collection<String> klucze = liczbaAndCount.keySet();

        for(String k: klucze)
        {
            for (Integer integer : najrzadziej) {
                if (Objects.equals(integer, liczbaAndCount.get(k)))
                { System.out.println("Liczba " + k + " powtorzyla sie " + liczbaAndCount.get(k) + " razy");
                    linia="Liczba " + k + " powtorzyla sie " + liczbaAndCount.get(k) + " razy";
                    bufferedWriter.write(linia);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();}
            }
        }
        System.out.println(" ");
        System.out.println("6 liczb, ktore sie powtorzyly najczesciej: ");
        linia="6 liczb, ktore sie powtorzyly najczesciej: ";
        bufferedWriter.write(linia);
        bufferedWriter.newLine();
        bufferedWriter.flush();
       ArrayList<String> wartosci=new ArrayList<>();
        for(String k: klucze)
        {

             for (Integer integer : najczesciej) {
                if (Objects.equals(integer, liczbaAndCount.get(k)))
                    if(!wartosci.contains(k))
                    {System.out.println("Liczba " + k + " powtorzyla sie " + liczbaAndCount.get(k) + " razy");
                        linia="Liczba " + k + " powtorzyla sie " + liczbaAndCount.get(k) + " razy";
                        bufferedWriter.write(linia);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        wartosci.add(k);}

            }
        }
        System.out.println();


        fileWriter.close();
        bufferedWriter.close();
        fr.close();
        br.close();

    }}

