class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> q = new LinkedList<>();

        // Add students to queue
        for (int student : students) {
            q.add(student);
        }

        int i = 0;
        int count = 0;

        while (!q.isEmpty() && count < q.size()) {

            if (q.peek() == sandwiches[i]) {

                // Student eats sandwich
                q.remove();

                // Move to next sandwich
                i++;

                // Reset count
                count = 0;

            } else {

                // Student goes to back
                q.add(q.remove());

                count++;
            }
        }

        return q.size();
    }
}