import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        Set<Integer> integerSet=new HashSet<>();
        for (int nr:nums)
            if (!integerSet.add(nr))
                integerSet.remove(nr);
        return integerSet.iterator().next();
    }
    public static void main(String[] args){

    }
}
