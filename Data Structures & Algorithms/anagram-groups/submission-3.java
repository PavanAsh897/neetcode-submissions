class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res= new ArrayList<>();
        Map<String,List<String>> map= new HashMap<>();

        for(String s: strs){
            char [] cA=s.toCharArray();
           Arrays.sort(cA);
           String NS= new String(cA);
            map.putIfAbsent(NS, new ArrayList<>());
            map.get(NS).add(s);


        }
        res= new ArrayList(map.values());
        return res;        
    }
}
