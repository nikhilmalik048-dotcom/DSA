class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        // Traverse array twice
        for (int i = 2 * n - 1; i >= 0; i--) {

            int index = i % n;

            // Remove elements smaller or equal
            while (!stack.isEmpty() && stack.peek() <= nums[index]) {
                stack.pop();
            }

            // Only fill answer during the first traversal
            if (i < n) {

                if (!stack.isEmpty()) {
                    ans[index] = stack.peek();
                }
            }

            // Push current element
            stack.push(nums[index]);
        }

        return ans;
    }
}