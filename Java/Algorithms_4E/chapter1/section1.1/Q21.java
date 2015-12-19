public class Q21{
    public static void main (String[] args) {
        int N = 10;
        String[] names = new String[N];
        int[] x = new int[N];
        int[] y = new int[N];
        float[] scores = new float[N];
        int count = 0;

        // read data from console
        for(int i=0; !StdIn.isEmpty(); i++){
            names[i] = StdIn.readString();
            x[i] = StdIn.readInt();
            y[i] = StdIn.readInt();
            scores[i] = (float)x[i]/(float)y[i];
            count ++;
        }

        // print table
        for(int i=0; i<count; i++){
            System.out.printf("%s\t%d\t%d\t%.3f\n", names[i], x[i], y[i], scores[i]);
        }
    }
}
