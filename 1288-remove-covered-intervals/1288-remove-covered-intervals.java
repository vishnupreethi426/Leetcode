class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0,r = 0;
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]){
                return (a[0]-b[0]);
            }else{
                return(b[1]-a[1]);
            }
    });
            for(int[]row:intervals){
                if(r<row[1]){
                    r= row[1];
                    count++;
                }
            }
        return count;
    }
}