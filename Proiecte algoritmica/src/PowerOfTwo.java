public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        int rezult = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                rezult++;
            n >>= 1;
        }
        return rezult == 1;
    }
}
