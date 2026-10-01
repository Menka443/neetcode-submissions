class MedianFinder {

  PriorityQueue<Integer> left;
  PriorityQueue<Integer> right;



    public MedianFinder() {

         // Max Heap
        left = new PriorityQueue<>(Collections.reverseOrder());

        // Min Heap
        right = new PriorityQueue<>();
    }


    
    public void addNum(int num) {

        if(left.isEmpty() || num <= left.peek()){
            left.offer(num);
        }else{
            right.offer(num);
        }

        //balance heap
        if(left.size() > right.size() + 1){
            right.offer(left.poll());
        }

        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
        
    }


    
    public double findMedian() {

        //odd number of median
        if(left.size() > right.size()){
            return left.peek();
        }

        //even number of element
        return (left.peek() + right.peek())/2.0;
        
    }
}
