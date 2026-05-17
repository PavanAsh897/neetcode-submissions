class Solution {
    public boolean isAnagram(String s, String t) {
        int n []= new int[256];
        for(int i=0;i<s.length();i++){
            n[s.charAt(i)]++;
        }
        for(int i=0;i<t.length();i++){
            n[t.charAt(i)]--;
        }
        for(int i=0;i<n.length;i++){
            if(n[i]!=0){
                return false;
            }
        }
        return true;

    }
}
