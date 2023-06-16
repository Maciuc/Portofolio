public class KADANEAlghoritm {
    public int maxSubArray(int[] nums) {  //Largest Sum Contiguous Subarray (Kadane’s Algorithm)
        int max = Integer.MIN_VALUE, sum = 0;

        for (int num : nums) {
            sum += num;
            max = Math.max(sum, max);

            if (sum < 0) sum = 0;
        }
        return max;
    }
}
