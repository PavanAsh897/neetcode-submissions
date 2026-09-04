class Solution {
    public boolean isAnagram(String s, String t) {
        int [] check = new int [256];
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i< s.length();i++){
            check[s.charAt(i)]++;
            check[t.charAt(i)]--;
        }
        for(int k: check){
            if(k!=0){
                return false;
            }
        }
        return true;
        

    }
}
