public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int total = nums.length > 0 ? 1 : 0;
        for (int number : nums)
            if (number != val)
                nums[total++ - 1] = number;
        return total == 0 ? 0 : total - 1;
    }
}
