public class FibDigits {

    static int HERE_COMES_THE_FUNCTION_HEADER(long N) {

        if (N == 0)
            return 0;
        if (N == 1 || N == 2)
            return 1;
        int x1 = 1, x2 = 1, x3 = 2;
        long i = 3;

        while (i < N) {
            x1 = x2;
            x2 = x3;
            x3 = x1 / 10 + x1 % 10 + x2 / 10 + x2 % 10;
            i++;
        }
        return x3;
    }

    public static void main(String[] args) {

        System.out.println(HERE_COMES_THE_FUNCTION_HEADER(3212312));
    }

}
