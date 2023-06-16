public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {

        int count = 1;
        for (int number : nums) {
            if (number > nums[count - 1])
                nums[count++] = number;
        }
        return count;
    }
}