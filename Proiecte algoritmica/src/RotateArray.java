import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n != 1) {
            k%=n;
            int[] lastsElement = new int[k];
            int j = 0;
            for (int i = n - k; i < n; i++)
                lastsElement[j++] = nums[i];

            for (int i = n - 1; i >= k; i--)
                nums[i] = nums[i - k];

            for (int i = 0; i < k; i++)
                nums[i] = lastsElement[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        rotate(a, 3);
        System.out.println(Arrays.toString(a));
    }
}
