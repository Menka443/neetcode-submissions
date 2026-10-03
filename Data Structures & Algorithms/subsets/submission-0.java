class Solution {


    public List<List<Integer>> subsets(int[] nums) {

          List<List<Integer>> result = new ArrayList<>();

          List<Integer> current = new ArrayList<>();

          backTrack(nums, 0, current, result);
          return result;

    }

         private void backTrack(
            int[] nums,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {


            // base case
            if(index == nums.length){
                result.add(new ArrayList<>(current));
                return;
            }

            // choise 1: take nums[index]
            current.add(nums[index]);

            //backTrack
            backTrack(nums, index+1, current, result);

            //undo
            current.remove(current.size()-1);

             // choise 2: 
            backTrack(nums, index+1, current, result);
          



        
    }
}
