class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n/2;
        int left = 0,right = 0;
        int lq = 0,rq = 0;

        for(int i=0;i<half;i++){
            if(num.charAt(i)=='?'){
                lq++;
            }else{
            left+=num.charAt(i)-'0';
        }
     }
        for(int i =half;i<n;i++){
            if(num.charAt(i)=='?'){
                rq++;
            }else{
            right+=num.charAt(i)-'0';
        }
    }
        int qdiff = lq - rq;
        int sumdiff = left - right;

        if(qdiff % 2!=0){
            return true;
        }
        return sumdiff!=9*(rq - lq)/2;
    }
}