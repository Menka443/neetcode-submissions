class Solution {

    public int findMin(int[] nums) {
       int start = 0;
       int end = nums.length-1;

       while(start < end){
        int mid = start + (end - start)/2;

        if(nums[mid] > nums[end]){
              // Minimum right side me hai
            start = mid+1;
        }else{
             // Minimum mid ya left side me ho sakta hai
            end = mid;
        }
       }
       return nums[start];
        


        
    }
}
