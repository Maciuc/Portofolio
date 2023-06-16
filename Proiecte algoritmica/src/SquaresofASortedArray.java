import java.util.PriorityQueue;

public class SquaresofASortedArray {

    public int[] sortedSquares(int[] nums) {
        /*PriorityQueue<Integer> queue=new PriorityQueue<>();
        for (int i:nums)
            queue.add(i*i);

        int[] nums2=new int[nums.length];
        for (int i=0;i<nums.length;i++)
            nums2[i]=queue.poll();

        return nums2;*/

        int[] nums2 = new int[nums.length];

        int i = 0;
        while (i < nums.length && nums[i] < 0)
            i++;
        int j = i - 1;
        int k = 0;
        while (j >= 0 && i < nums.length) {
            if (nums[j] * nums[j] == nums[i] * nums[i]) {
                nums2[k++] = nums[j] * nums[j--];
                nums2[k++] = nums[i] * nums[i++];
            } else if (nums[j] * nums[j] < nums[i] * nums[i])
                nums2[k++] = nums[j] * nums[j--];
            else
                nums2[k++] = nums[i] * nums[i++];
        }
        while (j >= 0)
            nums2[k++] = nums[j] * nums[j--];
        while (i < nums.length)
            nums2[k++] = nums[i] * nums[i++];
        return nums2;

    }
}