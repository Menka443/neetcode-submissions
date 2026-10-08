class Solution {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
           Arrays.sort(candidates);

        backTrack(candidates, target, 0, current, result);
        return result;
        
    }


    public void backTrack(int nums[],
     int target, 
     int index, 
     List<Integer> current,
      List<List<Integer>> result){

        //base case  target achieved
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        // sum crossed target
        if(target < 0){
            return;
        }

        //add
      for (int i = index; i < nums.length; i++) {


    if (i > index && nums[i] == nums[i - 1]) {
        continue;
    }

    current.add(nums[i]);

    backTrack(
        nums,
        target - nums[i],
        i + 1,
        current,
        result
    );

    current.remove(current.size() - 1);
}

    }
}
