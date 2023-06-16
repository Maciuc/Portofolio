import java.util.ArrayList;
import java.util.List;

public class IntersectionofTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int appearanceSize = Math.min(nums1.length, nums2.length);
        int[] appearances = new int[1000];
        List<Integer> intersection = new ArrayList<>();

        if (appearanceSize == nums1.length) {
            for (int num : nums1)
                appearances[num] += 1;
            for (int num : nums2)
                if (appearances[num] > 0) {
                    appearances[num]--;
                    intersection.add(num);
                }
        } else {
            for (int num : nums2)
                appearances[num] += 1;
            for (int num : nums1)
                if (appearances[num] > 0) {
                    appearances[num]--;
                    intersection.add(num);
                }
        }
        int[] rezult = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++)
            rezult[i] = intersection.get(i);
        return rezult;
    }

    public static void main(String[] args) {
    }

}
