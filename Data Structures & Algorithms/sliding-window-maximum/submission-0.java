class Solution {


    public int[] maxSlidingWindow(int[] nums, int k) {
        // base case
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        int n = nums.length;
        int[] ans = new int[n - k + 1];


        Deque<Integer> dq = new LinkedList<>();
        int index = 0;

        for(int i = 0; i < n; i++){
            //remove indices that are outside the current window
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            //Remove smaller element from the back
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            // add current index
            dq.offerLast(i);

            // window of size of k is formed
            if(i >= k-1){
                ans[index++] = nums[dq.peekFirst()];
            }

     }

        return ans;



        
    }
}
