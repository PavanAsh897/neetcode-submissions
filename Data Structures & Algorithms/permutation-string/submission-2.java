class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        Map<Character,Integer> s1Count= new HashMap<>();
        for(char c: s1.toCharArray()){
            s1Count.put(c,s1Count.getOrDefault(c,0)+1);
        }
        int l=0,r=s1.length();
        while(l<=s2.length()-r){
            Map<Character,Integer> s2Count=new HashMap<>();
            for(int i=l;i<l+r;i++){
                s2Count.put(s2.charAt(i),s2Count.getOrDefault(s2.charAt(i),0)+1);
            }
            if(s2Count.equals(s1Count)) return true;
            l++;
            
        }
        return false;
        
    }
}
