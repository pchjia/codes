import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class FileIndex {
    public static void main(String[] args) {
        HashMap<String, Set<File>> hm = new HashMap<>();
        try {
            for (String filename: args) {
                File f = new File(filename);
                Scanner in = new Scanner(f);
                while (in.hasNext()) {
                    String word = in.next();
                    if (!hm.containsKey(word)) {
                        hm.put(word, new HashSet<File>());
                    }
                    hm.get(word).add(f);
                }
                in.close();
            }
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the info you want to search: ");
            while (in.hasNext()) {
                String query = in.nextLine();
                if (hm.containsKey(query)) {
                    for (File f: hm.get(query)) {
                        System.out.println("\t" + f.getName());
                    }
                }
                System.out.println("Enter the info you want to search: ");
            }
        }
        catch (IOException e) {
            System.out.println("failed.");
            e.printStackTrace();
        }
    }
}
