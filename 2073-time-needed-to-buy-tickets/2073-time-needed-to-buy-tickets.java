class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        Queue<Integer> q = new LinkedList<>();

        // Store indexes
        for (int i = 0; i < tickets.length; i++) {
            q.add(i);
        }

        int time = 0;

        while (!q.isEmpty()) {

            int person = q.remove();

            // Person buys one ticket
            tickets[person]--;
            time++;

            // Target person finished
            if (person == k && tickets[person] == 0) {
                return time;
            }

            // If tickets are remaining, go to back
            if (tickets[person] > 0) {
                q.add(person);
            }
        }

        return time;
    }
}