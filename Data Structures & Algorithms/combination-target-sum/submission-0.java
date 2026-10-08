class Solution {


    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

         BackTrack(nums, target, 0, current, result);


        return result;
    }

    public void BackTrack(int nums[], 
    int target,
     int index, 
     List<Integer>current,
     List<List<Integer>> result){

 // BASE CASE
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        // sum crossed target
        if(target < 0){
            return;
        }

        for(int i = index; i < nums.length; i++){

            // add
            current.add(nums[i]);

            //backtrack
            BackTrack(nums, target - nums[i], i, current, result);

            //remove
            current.remove(current.size() - 1);

        }


     }

    
}
