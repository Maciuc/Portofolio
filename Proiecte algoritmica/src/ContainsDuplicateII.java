public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int oposite = 2;
            int number = nums[i];
            for (int j = i - 1; j >= i - k; j--) {
                if (j >= 0 && nums[j] == number)
                    return true;
                if (j + oposite < nums.length && nums[j + oposite] == number)
                    return true;
                oposite += 2;
            }
        }
        return false;
    }
}
