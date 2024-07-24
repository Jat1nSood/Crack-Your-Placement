class Solution {

    void merge(int low, int mid, int high, int[] arr){

        int left = low;
        int right = mid + 1;

        ArrayList<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            } else{
                temp.add(arr[right]);
                right++;
            }
        }

        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }
        for(int i = low; i <= high; i++){

            arr[i] = temp.get(i - low);
        }
    }

    int countPairs(int low, int mid, int high, int[] arr){

        int cnt = 0;
        int right = mid + 1;

        for(int i = low; i <= mid; i++){
            while(right <= high && (long)arr[i] > ((long)2 * (long)arr[right])){
                right++;
            }
            cnt += (right - (mid + 1));
        }
        return cnt;
    }
    int mergeSort(int low, int high, int[] arr){

        int cnt = 0;
        if(low == high) return cnt;

        int mid = low + (high - low)/2;

        cnt += mergeSort(low, mid, arr);
        cnt += mergeSort(mid + 1, high, arr);
        cnt += countPairs(low, mid, high, arr);
        merge(low, mid, high, arr);

        return cnt;
    }
    public int reversePairs(int[] nums) {
        
        int n = nums.length;
        return mergeSort(0, n-1, nums);
        
    }
}