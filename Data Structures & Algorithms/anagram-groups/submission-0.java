class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res= new HashMap<>();

        for(String s: strs){
            char charAry[] = s.toCharArray();
            Arrays.sort(charAry);
            String SortedS= new String(charAry);
            res.putIfAbsent(SortedS,new ArrayList<>());
            res.get(SortedS).add(s);

        }
        return new ArrayList<>(res.values());
        
        
    }

}
