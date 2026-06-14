class TimeMap {
    Map<String, List<pair<Integer, String>>> store;

    public TimeMap() {
        store= new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k->new ArrayList<>())
        .add(new pair(timestamp,value));
        
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)) return "";
        List<pair<Integer,String>> lst=store.getOrDefault(key,new ArrayList<>());
        int l=0,r=lst.size()-1;
        String res="";
        while(l<=r){
                int m=l+(r-l)/2;
                if(lst.get(m).getKey()<=timestamp){
                    res=lst.get(m).getVal();
                    l=m+1;

                }else{
                    r=m-1;
                }
             
        }
        return res;
        
        
    
    
        
    }
    class pair<K,V>{
        private K key;
        private V val;
        pair(K key,V val){
            this.key=key;
            this.val=val;
        }
        public K getKey(){
            return key;
        }
        public V getVal(){
            return val;
        }    
    }
}
