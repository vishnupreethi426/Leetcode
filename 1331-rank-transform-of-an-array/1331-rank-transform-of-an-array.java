class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] copy = arr.clone();
        Arrays.sort(copy);
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank = 1;
        for (int num : copy) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}