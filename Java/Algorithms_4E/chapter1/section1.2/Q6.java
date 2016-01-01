public class Q6 {
    public static void main (String[] args) {
        String s1 = args[0];
        String s2 = args[1];
        
        if (s1.length() != s2.length()) {
            return;
        }

        int start = s1.indexOf(s2.charAt(0));
        int end = s1.length();
        String s = s1.substring(start, end).concat(s1.substring(0, start));
        if (s.equals(s2)) {
            System.out.println("equals");
        }
        return;
    }
}
