public class PalindromeNumber {

    public static boolean isPalindrome(int x) {

        if (x < 0)
            return false;
        int xCopy = x, xReversed = 0;
        while (xCopy != 0) {
            xReversed = xReversed * 10 + xCopy % 10;
            xCopy /= 10;
        }
        return xReversed == x;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome(-10));
    }
}
