import java.util.Stack;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0 && nums2.length == 0) return 0.0;
        if (nums1.length == 0)
            return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - (nums2.length % 2 == 0 ? 1 : 0)]) / 2.00;
        if (nums2.length == 0)
            return (nums1[nums1.length / 2] + nums1[nums1.length / 2 - (nums1.length % 2 == 0 ? 1 : 0)]) / 2.00;

        int median = (nums1.length + nums2.length) / 2;
        int countToMedian = 0, countNums1 = 0, countNums2 = 0;
        Stack<Integer> elements = new Stack<>();

        while (countToMedian++ <= median) if (countNums2 != nums2.length && countNums1 != nums1.length) {
            if (nums1[countNums1] < nums2[countNums2]) elements.push(nums1[countNums1++]);
            else elements.push(nums2[countNums2++]);
        } else {
            if (countNums2 == nums2.length) elements.push(nums1[countNums1++]);
            else elements.push(nums2[countNums2++]);
        }

        if ((nums1.length + nums2.length) % 2 == 1) return elements.pop();
        return (elements.pop() + elements.pop()) / 2.00;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{}));
    }
}
