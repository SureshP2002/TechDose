//leetcode-295
//approach-prioriyQueue

class MedianFinder {
    PriorityQueue<Integer> MaxHeap;//minheap
    PriorityQueue<Integer> MinHeap;//maxheap

    public MedianFinder() {
        MaxHeap=new PriorityQueue(Collections.reverseOrder());//creating maxheap
        MinHeap=new PriorityQueue();//creating minheap
        
    }
    
    public void addNum(int num) {
        MaxHeap.offer(num);//adding the element to the MaxHeap
        MinHeap.offer(MaxHeap.poll());//adding element to minHeap  poping from maxheap
        if(MinHeap.size()>MaxHeap.size())//if the size exceeds
        {
            MaxHeap.offer(MinHeap.poll());//adding element to maxheap if the size of minheap is greater than maxheap poping from minheap
        }
        
    }
    
    public double findMedian() {
        if(MaxHeap.size()==MinHeap.size()) return (MaxHeap.peek()+MinHeap.peek())/2.0;//if sizes are equal then median is (maxheaps top +minheaps top)/2.0;
        else return MaxHeap.peek();//else return the maxheap;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
