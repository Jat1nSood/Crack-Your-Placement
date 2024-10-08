class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i =0; i < n - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < n - 2; j++){
                if(j > i + 1 && nums[j] == nums[j -1]) continue;
                int k = j + 1;
                int l = n -1;

                while(k < l){
                    long sum = (long)nums[i] +(long) nums[j] +(long) nums[k] + (long)nums[l];
                    if(sum == target){
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        // Collections.sort(temp);
                        set.add(temp);
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--; 
                    }
                    else if(sum < target) k++;
                    else l--;
                }
            }
        }
        ans.addAll(set);
        return ans;
    }
}