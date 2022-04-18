package test.java.backtracking;

import java.util.Arrays;

public class B603 {

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        Arrays.sort(nums);
        return sum % k == 0 && splitNums(nums, k, sum / k, new int[k], nums.length - 1);
    }

    public static boolean splitNums(int[] nums, int k, int avg, int[] res, int index) {
        if (index == -1) {
            for (int i = 0; i < k; i++) {
                if (res[i] != avg)
                    return false;
            }
            return true;
        }
        for (int i = 0; i < k; i++) {
            // 当前边已经填满，剪枝
            if ((res[i] + nums[index] > avg) || (i > 0 && res[i] == res[i - 1]))
                continue;
            res[i] += nums[index];
            if (splitNums(nums, k, avg, res, index - 1))
                return true;
            res[i] -= nums[index];
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 3, 10, 2, 6, 5, 10, 6, 8, 3, 2, 1, 6, 10, 7, 2};
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(nums, 4));
    }
}
