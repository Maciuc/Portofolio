public class ReverseInteger {
    public static int reverse(int x) {
        if (x > -10 && x < 10)
            return x;

        long number = 0;
        while (x != 0) {
            if (number > Integer.MAX_VALUE || number < Integer.MIN_VALUE)
                return 0;
            number = number * 10 + x % 10;
            x /= 10;
        }
        return (int) number;
    }

    public static void main(String[] args) {

        System.out.println(reverse(-123));
    }

}
