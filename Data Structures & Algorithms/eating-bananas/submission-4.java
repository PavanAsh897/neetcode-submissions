class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int MaxA=0;
        for(int i:piles){
            MaxA=Math.max(MaxA,i);
        }
        int l=0, r= MaxA;
        int res=r;
        while(l<=r){
            int speed =l+(r-l)/2;
            int totalHours=0;
            for(int pile: piles){
                totalHours+= Math.ceil((double)pile/speed);

            }
            if(totalHours<=h){
                res=Math.min(res,speed);
                r=speed-1;
            }else{
                l=speed+1;
            }
        }
        return res;
        
    }
}
