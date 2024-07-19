class Solution {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int totalSubArrays = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i = 0; i < n; i++){
            sum += nums[i];
            int difference = sum - k;
            if(map.containsKey(difference)){
                totalSubArrays += map.get(difference);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return totalSubArrays;
    }
}