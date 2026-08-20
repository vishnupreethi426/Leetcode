class Solution {
    public int[] resultArray(int[] nums) {
        int arr1[] = new int[nums.length];
        arr1[0] = nums[0];
        int arr2[] = new int[nums.length];
        arr2[0] = nums[1];
        int j = 1;
        int k = 1;
        for(int i = 2;i<nums.length;i++){
            if(arr1[j-1] > arr2[k-1]){
                arr1[j] = nums[i];
                j++;
            }
            else{
                arr2[k] = nums[i];
                k++;
            }

        }
       int[] res = new int[nums.length];
        for (int i = 0; i < j; i++) {
            res[i] = arr1[i];
        }
        for (int i = 0; i < k; i++) {
            res[j + i] = arr2[i];
        }
        return res;
    }
}