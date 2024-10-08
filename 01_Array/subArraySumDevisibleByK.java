class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        int result = 0;

        for(int i = 0; i < n; i++){

            sum += nums[i];
            int rem = sum % k;
            if(rem < 0) rem += k;
            if(map.containsKey(rem)){
                result += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return result;
    }
}