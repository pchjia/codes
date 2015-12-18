public class Q13{
    /**
     * print the transpose of an two dimension array 
     * @author pchjia
     * @param a two dimension array
     * @param M row
     * @param N column
     */
    public static void printArr(int[][] a, int M, int N){
        for(int j=0; j<N; j++){
            for(int i=0; i<M; i++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}};
        printArr(a, a.length, a[0].length);
    }
}
