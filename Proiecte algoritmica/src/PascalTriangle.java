import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascal = new ArrayList<>();
        pascal.add(List.of(1));
        if (numRows == 1)
            return pascal;

        pascal.add(Arrays.asList(1, 1));
        if (numRows == 2)
            return pascal;

        for (int row = 2; row < numRows; row++) {
            List<Integer> line = new ArrayList<>();
            for (int i = 0; i <= row; i++)
                if (i == 0 || i == row)
                    line.add(1);
                else
                    line.add(pascal.get(row - 1).get(i - 1) + pascal.get(row - 1).get(i));
            pascal.add(line);
        }
        return pascal;
    }

    /*public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> adder = new ArrayList<>();
            int num = 1;
            for(int j=0;j<=i;j++){
                adder.add(num);
                num = num * (i-j)/(j+1);
            }
            ans.add(adder);
        }
        return ans;
    }*/
}
