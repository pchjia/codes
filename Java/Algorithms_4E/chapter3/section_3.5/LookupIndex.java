import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class LookupIndex {
    public static void main(String[] args) {
        HashMap<String, Queue<String>> hm = new HashMap<>();
        HashMap<String, Queue<String>> mh = new HashMap<>();
        String sep = args[1];
        try (BufferedReader f = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = f.readLine()) != null) {
                String[] tokens = line.split(sep);
                String key = tokens[0];
                for (int i=1; i<tokens.length; i++) {
                    String val = tokens[i];
                    if (!hm.containsKey(key)) {
                        hm.put(key, new LinkedList<String>());
                    }
                    hm.get(key).add(val);

                    if (!mh.containsKey(val)) {
                        mh.put(val, new LinkedList<String>());
                    }
                    mh.get(val).add(key);
                }
            }

            Scanner in = new Scanner(System.in);
            System.out.println("Enter the info you want to seek: ");
            while (in.hasNext()) {
                String query = in.nextLine();
                if (hm.containsKey(query)) {
                    for (String val: hm.get(query)) {
                        System.out.println("\t" + val);
                    }
                }

                if (mh.containsKey(query)) {
                    for (String val: mh.get(query)) {
                        System.out.println("\t" + val);
                    }
                }
                System.out.println("Enter the info you want to seek: ");
            }
        } catch (IOException e) {
            System.out.println("open file error!");
            e.printStackTrace();
        }
    }
}
