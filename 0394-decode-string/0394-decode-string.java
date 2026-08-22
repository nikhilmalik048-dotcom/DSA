class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {

            // Build the number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // Start of encoded string
            else if (ch == '[') {

                numStack.push(num);
                stringStack.push(current.toString());

                num = 0;
                current = new StringBuilder();
            }

            // End of encoded string
            else if (ch == ']') {

                int repeat = numStack.pop();
                String previous = stringStack.pop();

                StringBuilder temp = new StringBuilder(previous);

                for (int i = 0; i < repeat; i++) {
                    temp.append(current);
                }

                current = temp;
            }

            // Normal character
            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}