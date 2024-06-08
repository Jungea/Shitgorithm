package LTC;

/**
 * 523. Continuous Subarray Sum
 */
public class LTC523 {


    // 미리 계산한 합계를 써도 시간초과
    public boolean checkSubarraySum3(int[] nums, int k) {

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }

        int val = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                val = dp[j] - dp[i] + nums[i];
                if (val % k == 0) {
                    return true;
                }
            }

        }

        return false;

    }

    // 시간초과
    public boolean checkSubarraySum2(int[] nums, int k) {

        int val = 0;
        for (int i = 0; i < nums.length; i++) {
            val = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                val += nums[j];
                if (val % k == 0) {
                    System.out.println(i + " " + val + " " + k);
                    return true;
                }
            }

        }

        return false;

    }
}
