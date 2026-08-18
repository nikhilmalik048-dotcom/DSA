class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {

            if (op.equals("C")) {
                stack.pop();

            } else if (op.equals("D")) {
                int x = stack.peek();
                stack.push(2 * x);

            } else if (op.equals("+")) {
                int n = stack.size();

                int last = stack.get(n - 1);
                int secondLast = stack.get(n - 2);

                stack.push(last + secondLast);

            } else {
                // Convert String to Integer
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;

        for (int score : stack) {
            sum += score;
        }

        return sum;
    }
}