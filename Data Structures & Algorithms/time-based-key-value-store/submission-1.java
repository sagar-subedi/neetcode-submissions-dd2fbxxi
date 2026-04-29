class TimeMap {

    Map<String, List<Pair>> map = new HashMap<>();
    
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)){
            map.put(key, new ArrayList());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> values = map.get(key);

        if (values == null || values.size() == 0 ) return "";

        int low = 0;
        int high = values.size()-1;
        String result = "";

        while( low <= high ) {
            int mid = low + (high - low )/2;
        
            if ( values.get(mid).timestamp <= timestamp ){
                result = values.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        } 
        return result;
    }

    public class Pair {
        int timestamp;
        String value;

        Pair( int timestamp, String value ) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
