public class AddDigits {
    public static int addDigits(int num) {

        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        if (sum > 9)
            return addDigits(sum);

        return sum;
    }

    /*public int addDigits(int num) {
        if(num == 0)
            return 0;
        else if(num % 9 == 0)
            return 9;
        else return num % 9;
    }*/
}
