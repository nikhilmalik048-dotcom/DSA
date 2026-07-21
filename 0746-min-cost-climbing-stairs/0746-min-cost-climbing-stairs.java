import java.util.Arrays;

class Solution {
    int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    private int minCost(int[] cost, int n) {
        if (n == 0) {
            return cost[0];
        }

        if (n == 1) {
            return cost[1];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
        return dp[n];
    }
}