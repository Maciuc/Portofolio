import java.util.HashSet;
import java.util.Set;

public class CheckIfRowsContainsAllElements {
    public static boolean checkValid(int[][] matrix) {
        if (matrix.length==1)
            return true;

        for (int[] ints : matrix) {
            Set<Integer> set = new HashSet<>();
            for (int element : ints)
                if (!set.add(element))
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}
