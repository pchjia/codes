public class Q33{
    public static void main (String[] args) {
        double[][] a = new double[][]{{1, 2, 3}, {4, 5, 6}};
        double[][] b = new double[][]{{1, 2}, {3, 4}, {5, 6}};
        
        double[] v1 = new double[]{1, 2 , 3};
        double[] v2 = new double[]{1, 2, 3};

        double dot= Matrix.dot(v1, v2);
        double[][] pro_mm = Matrix.mult(a, b);
        double[][] trans = Matrix.transpose(a);
        double[] pro_mv = Matrix.mult(a, v1);
        double[] pro_vm = Matrix.mult(v1, b);
    }
}

class Matrix{
    /**
     * vector dot-multiply, x and ymust  have the same length.
     * @author pchjia
     * @param x vector
     * @param y vector
     * @return pruduct
     */ 
    public static double dot(double[] x, double[] y){
        if(x.length != y.length){
            return 0.0;
        }
        
        double sum=0;
        int len = x.length;
        
        for(int i=0; i<len; i++){
            sum += x[i] * y[i];
        }
        return sum;
    }

    /**
     * matrx multiply.
     * @param a matrix
     * @param b matrix
     * @return product
     */
    public static double[][] mult(double[][] a, double[][] b){
        if(a[0].length != b.length){
            return new double[0][0];
        }
        int row = a.length;
        int col = b[0].length;
        double[][] pro = new double[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                for(int k=0; k<a[0].length; k++){
                    pro[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return pro;
    }

    /**
     * matrix transposition
     * @param a matrix
     * @return matrix after transposition
     */
    public static double[][] transpose(double[][] a){
        double[][] res = new double[a[0].length][a.length];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                res[j][i] = a[i][j];
            }
        }
        return res;
    }

    /**
     * matrix multiply vector
     * @param a marix
     * @param x vector
     * @return product
     */
    public static double[] mult(double[][] a, double[] x){
        double[] pro = new double[a.length];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<x.length; j++){
                pro[i] += a[i][j] * x[j];
            }
        }
        return pro;
    }

    /**
     * vector multiply matrix
     * @param y vector
     * @param x matrix
     * @return product
     */
    public static double[] mult(double[] y, double[][] a){
        double[] pro = new double[a[0].length];
        for(int i=0; i<a[0].length; i++){
            for(int j=0; j<y.length; j++){
                pro[i] += y[j] * a[j][i];
            }
        }
        return pro;
    }
}
