import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SequentialSearchST<String, Double> st = new SequentialSearchST<String, Double>();
        while (in.hasNext()) {
            String word = in.next();
            double sco = score(word);
            st.put(word, sco);
        }

        for (String key: st.keys()) {
            System.out.println(key + " " + st.get(key));
        }
    }

    public static double score(String word) {
        double sco = 0.00;
        switch (word) {
            case "A+":
                sco = 4.33;
                break;
            case "A":
                sco = 4.00;
                break;
            case "A-":
                sco = 3.67;
                break;
            case "B+":
                sco = 3.33;
                break;
            case "B":
                sco = 3.00;
                break;
            case "B-":
                sco = 2.67;
                break;
            case "C+":
                sco = 2.33;
                break;
            case "C":
                sco = 2.00;
                break;
            case "C-":
                sco = 1.67;
                break;
            case "D":
                sco = 1.00;
                break;
            case "F":
                sco = 0.00;
                break;
        }
        return sco;
    }
}
