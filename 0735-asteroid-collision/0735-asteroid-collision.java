class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean alive = true;

            // Collision can happen only when:
            // stack top is moving right
            // current asteroid is moving left
            while (alive && asteroid < 0 &&
                   !stack.isEmpty() && stack.peek() > 0) {

                int top = stack.peek();

                // Top asteroid is smaller
                if (top < -asteroid) {
                    stack.pop();
                }

                // Both are same size
                else if (top == -asteroid) {
                    stack.pop();
                    alive = false;
                }

                // Top asteroid is bigger
                else {
                    alive = false;
                }
            }

            // Add asteroid if it survived
            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}