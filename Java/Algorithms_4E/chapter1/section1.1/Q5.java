public class Q5{
    /*
     * double x, y; if x and y between 0~1, print true, else print false;
     */
    public static void main (String[] args) {
        double x;
        double y;
        boolean tag = true;
        x = StdIn.readDouble();
        y = StdIn.readDouble();
        if(x <= 0.0 || x >= 1.0){
            tag = false;
        }
        if(y <= 0.0 || y >= 1.0){
            tag = false;
        }
        StdOut.println(tag);
    }
}
