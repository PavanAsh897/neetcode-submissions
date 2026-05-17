class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res= new ArrayList<>();
        int l=0;
        while(l<=nums.length-k){
            int max=nums[l];
            for(int i=l;i<l+k;i++ ){
                max=Math.max(max,nums[i]);
            }
            res.add(max);
            l++;
            
        }

       int size=res.size();
       int []ares= new int[size];
       for(int i=0; i<size;i++){
        ares[i]=res.get(i);
       }
       return ares;
    }
}
