class Solution {
    public String minWindow(String s, String t) {
        if(t=="") return "";
        Map <Character,Integer> countT= new HashMap<>();
        Map<Character, Integer> window= new HashMap<>();
        for(char c: t.toCharArray()){
            countT.put(c,countT.getOrDefault(c,0)+1);
        }
        int res[]=new int[]{-1,-1};
        int reslen =Integer.MAX_VALUE;
        int l=0;
        int have=0,need=countT.size();
        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            window.put(c,window.getOrDefault(c,0)+1);
            if(countT.containsKey(c)&& countT.get(c)==window.get(c)){
                have++;
            }
            while(have==need){
                if((r-l+1)<reslen){
                    reslen=r-l+1;
                    res[0]=l;
                    res[1]=r;

                }
                char leftchar=s.charAt(l);
                window.put(leftchar,window.getOrDefault(leftchar,0)-1);
                if(countT.containsKey(leftchar)&& countT.get(leftchar)>window.get(leftchar)){
                have--;
            }
            l++;
            }
            
        }

return reslen==Integer.MAX_VALUE?"": s.substring(res[0],res[1]+1);
        
    }
}
