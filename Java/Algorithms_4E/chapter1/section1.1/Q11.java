import java.util.Random;

public class Q11{
    /**
     * print two dimension boolean array
     * if its value equals true, print *; otherwise print s space;
     */
    public static void main (String[] args) {
        int row;
        int col;
        row = StdIn.readInt();
        col = StdIn.readInt();
        boolean[][] a = new boolean[row][col];

        randomBooleanArr(a, row, col, 5);

        // columns number
        System.out.print("  ");
        for(int j=0; j<col; j++){
            System.out.print(j+1 + " ");
        }
        System.out.println();

        // print each line
        for(int i=0; i<row; i++){
            System.out.print(i+1 + " ");
            for(int j=0; j<col; j++){
                if(a[i][j] == true){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    /**
     * make severals items of the array be true randomly
     * @authoe pchjia
     * @param a two dimension boolean array
     * @param row row number
     * @param col column number
     * @param N true numbers in this array
     */
    private static void randomBooleanArr(boolean[][] a, int row, int col, int N){
        Random r = new Random();
        Random c = new Random();
        for(int i=0; i<N; i++){
            int x = r.nextInt(row);
            int y = c.nextInt(col);
            if(a[x][y] == true){
                i--;
            }
            a[x][y] = true;
        }
    }
}
