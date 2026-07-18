class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        int temp;
        while(max!=0){
            temp = min%max;
            min = max;
            max = temp;
        }
        return min;
    }
}