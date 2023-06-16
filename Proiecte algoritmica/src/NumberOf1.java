public class NumberOf1 {
    public static int hammingWeight(int n) {
        int rezult = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                rezult++;
            n >>>= 1;
        }
        return rezult;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(1110001101));

    }
}
