class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res= new HashMap<>();

        for(String s: strs){
            char charAry[] = s.toCharArray();
            char [] ch= new char[26];
           for(char c: charAry){
            ch[c-'a']++;
           }
           String SortedS = Arrays.toString(ch);
            res.putIfAbsent(SortedS,new ArrayList<>());
            res.get(SortedS).add(s);

        }
        return new ArrayList<>(res.values());
        
        
    }

}
