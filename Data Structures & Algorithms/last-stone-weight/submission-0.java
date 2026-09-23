class Solution {

    public int lastStoneWeight(int[] stones) {

       PriorityQueue<Integer> pq =
    new PriorityQueue<>(Collections.reverseOrder());

        //add all stone
        for(int stone : stones){
            pq.offer(stone);
        }

        //keep smashing two heaviest stone
        while(pq.size() > 1){
            int x = pq.poll();
            int y =  pq.poll();

            if(x != y){
                pq.offer(x-y);
            }
        }
        //0 or 1 stone remaining
        if(pq.isEmpty()){
            return 0;
        }
        return pq.peek();
        
    }
}
