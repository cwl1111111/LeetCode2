package com.cai.demo10;

import java.util.PriorityQueue;

public class MedianFinder {
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;
        public MedianFinder() {
            min = new PriorityQueue<>();
            max = new PriorityQueue<>((o1, o2)->o2-o1);
        }

        public void addNum(int num) {
            if(max.size()<=min.size()){
                min.offer(num);
                max.offer(min.poll());
            }else{
                max.offer(num);
                min.offer(max.poll());
            }
        }

        public double findMedian() {
            if(max.size()==min.size()){
                return (max.peek()+min.peek())/2.0;
            }else{
                return max.peek();
            }
        }

}
