class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int start = 1;
        int end = findMax(piles);
        int ans = end;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            int hours = calculateHours(piles, mid);

            if (hours <= h) {
                ans = mid;
                end = mid - 1;   // Try smaller speed
            } else {
                start = mid + 1; // Increase speed
            }
        }

        return ans;
    }

    // Find maximum pile
    private int findMax(int[] piles) {
        int max = piles[0];

        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        return max;
    }

    // Calculate total hours needed at given speed
    private int calculateHours(int[] piles, int speed) {

        int hours = 0;

        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }

        return hours;
    }
}