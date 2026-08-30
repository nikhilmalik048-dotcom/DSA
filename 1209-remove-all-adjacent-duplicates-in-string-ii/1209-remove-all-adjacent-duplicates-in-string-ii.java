class Solution {

    public String removeDuplicates(String s, int k) {

        // Stack stores {character, count}
        Stack<int[]> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // If stack is not empty and top character is same
            if (!stack.isEmpty() && stack.peek()[0] == ch) {

                stack.peek()[1]++;

                // Remove when count reaches k
                if (stack.peek()[1] == k) {
                    stack.pop();
                }

            } else {

                // New character
                stack.push(new int[]{ch, 1});
            }
        }

        // Build answer
        StringBuilder result = new StringBuilder();

        for (int[] pair : stack) {

            char ch = (char) pair[0];
            int count = pair[1];

            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}