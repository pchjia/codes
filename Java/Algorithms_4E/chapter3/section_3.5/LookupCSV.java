import java.io.BufferedReader;
import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class LookupCSV {
    public static void main(String[] args) {
        int key = Integer.parseInt(args[1]);
        int val = Integer.parseInt(args[2]);
        HashMap<String, String> hst = new HashMap<>();
        try (
                BufferedReader f = new BufferedReader(new FileReader(args[0]));
        ){
            String line;
            while ((line = f.readLine()) != null) {
                String[] fields = line.split(",");
                hst.put(fields[key], fields[val]);
            }

            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                 String query = in.next();
                 String res = hst.get(query);
                 System.out.println(res);
            }
        } catch (IOException e) {
            System.out.println("file read faied");
            e.printStackTrace();
        }
    }
}
