class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Current temperature is warmer
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int prev = stack.pop();

                ans[prev] = i - prev;
            }

            // Store current index
            stack.push(i);
        }

        return ans;
    }
}