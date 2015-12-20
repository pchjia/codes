public class Q30{
    public static void main (String[] args) {
        int row = StdIn.readInt();
        int col = StdIn.readInt();
        boolean[][] a = new boolean[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if((i != j) && (euclid(i+1, j+1) == 1)){
                    a[i][j] = true;
                }else{
                    a[i][j] = false;
                }
            }
        }

        printBooleanArr(a);
    }

    public static int euclid(int x, int y){
        if(y == 0){
            return x;
        }
        int r = x % y;
        return euclid(y, r);
    }
    
    public static void printBooleanArr(boolean[][] a){
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
       
    }
}
