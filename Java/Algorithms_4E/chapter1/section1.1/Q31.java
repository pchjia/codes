public class Q31{
    public static void main (String[] args) {
       int N = StdIn.readInt();
       double p = StdIn.readDouble();
       randomConn(N, p);
    }

    public static void randomConn(int N, double p){
        StdDraw.setCanvasSize(512, 512);
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.setPenRadius(.05);

        double[][] points = new double[N][2];
        for(int i=0; i<N; i++){
            points[i][0] = Math.cos(2*Math.PI*i/N);
            points[i][1] = Math.sin(2*Math.PI*i/N);
            StdDraw.point(points[i][0], points[i][1]);
        }
        
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.GRAY);

        for(int i=0; i<N; i++){
            if(Math.random() < p){
                StdDraw.line(0.0, 0.0, points[i][0], points[i][1]);
            }
        }
    }
}
