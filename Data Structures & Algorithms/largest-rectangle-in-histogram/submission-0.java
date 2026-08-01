class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
          
          // first we will go with brute force approach
          for(int i = 0; i < n; i++){
            int height = heights[i];

            //expand left
            int left = i;
            while(left > 0 && heights[left-1] >= height){
                left--;
            }

            //expand right
            int right = i;
            while(right < n-1 && heights[right + 1] >= height){
                right++;
            }

            //width
            int width = right - left + 1;

            //ares
            int area = height * width;
            //maxarea
            maxArea = Math.max(maxArea, area);


          }

          return maxArea;
        
    }
}
