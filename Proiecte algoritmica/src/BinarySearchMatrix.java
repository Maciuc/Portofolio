public class BinarySearchMatrix {

    public int search(int[] nums, int target) {

        int low = 0, high = nums.length - 1;
        int maxx = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= maxx && nums[mid] <= target)
                maxx=nums[mid];
            else {
                if (target > nums[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

}
