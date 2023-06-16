public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {

        int n= matrix.length;
        int m=matrix[0].length;
        int maxDiagonal=Math.min(n,m);

        while (maxDiagonal!=0) {
            for (int upperLefti=0;upperLefti<=n-maxDiagonal;upperLefti++)
                for (int upperLeftj=0;upperLeftj<=m-maxDiagonal;upperLeftj++) {
                    boolean haveToBreak = false;
                    for (int i = upperLefti; i < maxDiagonal; i++) {
                        for (int j = upperLeftj; j < maxDiagonal; j++) {
                            if (matrix[i][j] != '1') {
                                haveToBreak = true;
                                break;
                            }
                        }
                        if (haveToBreak)
                            break;
                    }
                    if (!haveToBreak)
                        return maxDiagonal-1>0?(maxDiagonal-1)*(maxDiagonal-1):1;
                }
            maxDiagonal--;
        }
        return 0;
    }

    public static void main(String[] args) {

        char[][] matrix=new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));

    }
}
