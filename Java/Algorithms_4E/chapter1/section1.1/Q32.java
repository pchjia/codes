public class Q32{
    public static void main (String[] args) {
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);
        int[] a = new int[N];

        while(!StdIn.isEmpty()){
            double i = StdIn.readDouble();
            if((i >= l) && (i <=r)){
                int n = (int)((i-l)*N/(r-l));
                a[n] ++;
            }
        }
        
        drawHistogram(N, l, r, a);
    }

    public static void drawHistogram(int N, double l, double r, int[] a){
        StdDraw.setCanvasSize(512, 512);
        StdDraw.setXscale(r, l);
        StdDraw.setYscale(0, N);
        StdDraw.setPenRadius(.01);

        double width = (r-l)/(double)N;
        for(int i=0; i<N; i++){
            double x = l + i*width + width/2.0;
            double y = a[i] / 2.0;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, width/2.0, rh);
        }
    }
}
