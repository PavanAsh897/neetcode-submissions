class TimeMap {
    Map<String,List<pair<Integer,String>>> map;

    public TimeMap() {
        map=new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k->new ArrayList<>())
        .add(new pair<>(timestamp,value));
        
    }
    
    public String get(String key, int timestamp) {
        List<pair<Integer,String>> value = map.getOrDefault(key,new ArrayList<>());
        int l=0,r=value.size()-1;
        String res="";
        while(l<=r){
            int m=l+(r-l)/2;
            if(value.get(m).getKey()<=timestamp){
                res= value.get(m).getValue();
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return res;
        
    }
    static class pair<T,U>{
        final T key;
        final U value;
        pair(T key, U value){
            this.key =key;
            this.value= value;
        }
        T getKey(){
            return key;
        }
        U getValue(){
            return value;
        }
    }
}
