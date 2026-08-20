class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            // Ignore empty strings and "."
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Go to parent directory
            else if (part.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Normal directory
            else {
                stack.push(part);
            }
        }

        // Build final path
        StringBuilder result = new StringBuilder();

        for (String folder : stack) {
            result.append("/").append(folder);
        }

        // If stack is empty, return root
        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }
}