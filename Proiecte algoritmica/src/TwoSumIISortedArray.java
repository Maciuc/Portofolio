import java.util.HashSet;
import java.util.Set;

public class TwoSumIISortedArray {
    public static int[] twoSum(int[] numbers, int target) {

        Set<Integer> rezults = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!rezults.add(numbers[i]) || !rezults.add(target - numbers[i])) {
                return new int[]{i};
            }
            System.out.println(rezults);
        }
        return new int[]{};
    }

    public static void main(String[] args){

    }
}
