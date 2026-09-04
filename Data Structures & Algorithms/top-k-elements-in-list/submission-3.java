class Solution {
    public int[] topKFrequent(int[] nums, int k) {

    //     Map<Integer,Integer> map =new HashMap<>();
    //     for(int i: nums){
    //         map.put(i,map.getOrDefault(i,0)+1);

    //     }
    //     List<Map.Entry<Integer,Integer>> li= new ArrayList<>(map.entrySet());
    //     li.sort((a,b)->b.getValue()-a.getValue());
    //     int [] arr= new int[k];
    //    for(int i=0;i<k;i++){
    //     arr[i]=li.get(i).getKey();
    //    }
    //    return arr;
    List<Integer> [] freq =new List[nums.length+1];
    Map<Integer,Integer> count= new HashMap<>();
    for(int i=0; i< freq.length; i++){
        freq[i]= new ArrayList<>();
    }
    for(int x: nums){
        count.put(x,count.getOrDefault(x,0)+1);
    }
    for(Map.Entry<Integer,Integer> entry: count.entrySet()){
        freq[entry.getValue()].add(entry.getKey());
    }
    int [] arr= new int[k];
    int index=0;
    for(int i=freq.length-1;i>0&& index<k;i--){
        for(int n: freq[i]){
            arr[index++]=n;

        }
    }
    return arr;


    }
}
