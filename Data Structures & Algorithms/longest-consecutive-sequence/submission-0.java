class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set= new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        int longest=0;
        for(int num: nums){
            if(!set.contains(num-1)){
                int len=0;
                while(set.contains(num+len)){
                    len++;
                }
                longest= Math.max(len,longest);

            }
        }
        return longest;
        
    }
}
