class MedianFinder {

    Queue<Integer> lQ;
    Queue<Integer> hQ;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        lQ = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        hQ = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lQ.offer(num);
        hQ.offer(lQ.poll());
        if (hQ.size() > lQ.size()) {
            lQ.offer(hQ.poll());
        }
    }
    
    public double findMedian() {
        if ((lQ.size()+hQ.size()) % 2 == 0) return (lQ.peek() + hQ.peek()) / 2.0;
        else return lQ.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */