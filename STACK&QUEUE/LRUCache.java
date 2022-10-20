//leetcode-146
//TC-O(1);



class LRUCache {
    int capacity;
    Queue<Integer> ans=new ArrayDeque<>();//creating an Deque
    Map<Integer,Integer> map=new LinkedHashMap<>();//creating an hashMap;

    public LRUCache(int capacity) {
        this.capacity=capacity;//size 
        
    }
    
    public int get(int key) {
        if(map.containsKey(key))//if the key already exists
        {
            ans.remove(key);//removing key from queue
            ans.offer(key);//adding key at back in the queue
            return map.get(key);//getting the value from the map
        }
        else
        {
            return -1;//if key value not exists;
        }
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))//if key already exits
        {
            ans.remove(key);//removing the key from the queue
            ans.offer(key);//and offering it back of the queue
            map.put(key,value);//adding key value to map
        }
        else
         {
            if(ans.size()<capacity)//if size is less than capacity
             {
                ans.offer(key);//adding back to queue
             }
             else//if size greater
             {
                 map.remove(ans.poll());//removing the first queue key
                 ans.offer(key);//adding back of the queue
             }
               map.put(key,value);//adding in map key value
         }
          
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
