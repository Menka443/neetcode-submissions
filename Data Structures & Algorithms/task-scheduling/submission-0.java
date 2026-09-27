class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Step 1: Count frequency
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Max Heap
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0) {
                pq.offer(f);
            }
        }

        // Step 3: Cooldown queue
        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        // Step 4: Run until both are empty
        while (!pq.isEmpty() || !cooldown.isEmpty()) {

            time++;

            // If a task is ready again, put it back in heap
            if (!cooldown.isEmpty() &&
                cooldown.peek()[1] == time) {

                pq.offer(cooldown.poll()[0]);
            }

            // Take highest frequency task
            if (!pq.isEmpty()) {

                int remaining = pq.poll();

                remaining--;

                // If task still remains, put it in cooldown
                if (remaining > 0) {
                    cooldown.offer(new int[]{remaining, time + n + 1});
                }
            }
        }

        return time;
    }
}