import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    static int sumDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    static boolean isHappy(int n) {
        Set<Integer> sums = new HashSet<>();
        sums.add(n);
        while (sumDigits(n) != 1)
            if (!sums.add(sumDigits(n)))
                return false;
            else
                n = sumDigits(n);
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isHappy(19));
    }
}
