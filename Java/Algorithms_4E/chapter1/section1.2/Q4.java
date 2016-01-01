/*
 * String string1 = "hello";
 * String string2 = string1;
 * string1 = "world";
 * StdOut.println(string1);         // wordl
 * StdOut.println(string2);         // hello
 */

public class Q4 {
    public static void main (String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }
}
