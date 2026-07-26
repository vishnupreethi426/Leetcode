class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int pos1 = nums[n-1]*nums[n-2]*nums[n-3];
        int pos2 = nums[0]*nums[1]*nums[n-1];
        return Math.max(pos1,pos2);
    }
}