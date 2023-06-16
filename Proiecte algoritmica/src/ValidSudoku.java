import java.util.*;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        Set vazut=new HashSet();

        for (int i=0;i< board.length;i++)
            for (int j=0;j<board[i].length;j++){
                if (board[i][j]=='.')
                    continue;
                String valoare="("+board[i][j]+")";
                if (!vazut.add(i+valoare) || !vazut.add(valoare+j) || !vazut.add(i/3+valoare+j/3))
                    return false;

            }
        return true;
    }
   //WTF REZOVARE
    /*public boolean isValidSudoku(char[][] board) {

        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];

        for(int i = 0;i<9;i++){
            for(int j =0;j<9;j++){
                char c= board[i][j];
                if(c != '.'){
                    if((row[i]&(1<<(c-'0')))>0)
                        return false;

                    if((col[j]&(1<<(c-'0')))>0)
                        return false;

                    if((box[i/3*3+j/3]&(1<<(c-'0')))>0)
                        return false;
                    row[i]|=1<<(c-'0');

                    col[j]|=1<<(c-'0');

                    box[i/3*3+j/3]|=1<<(c-'0');
                }
            }
        }
        return true;
    }*/

    public static void main(String[] args) {

        System.out.println(2<<5);
    }
}
