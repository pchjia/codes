public class Q4{
    /*
     * a. if(a > b) then c = 0; : there is no "then" in java
     * b. if a > b  {c = 0}; : missed parenthesis in if
     * c. if(a > b) c = 0; : correct!
     * d. if(a > b) c = 0 else b = 0;: missed semicolon
     */
    public static void main (String[] args) {
        int a=1, b=2, c=3;
        
        if(a > b) then c = 0;
        if a > b  {c = 0};
        if(a > b) c = 0;
        if(a > b) c = 0 else b = 0;
    }
}
