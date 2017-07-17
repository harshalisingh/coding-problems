package leetcode.Design;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverage {
    private int size;
    private int sum;
    private Queue<Integer> queue;

    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        this.queue = new ArrayDeque<>();
    }

    public double next(int val) {
    	queue.offer(val);
        if (queue.size() > size) {
            sum -= queue.poll();
        }
        sum += val;
        return (double) sum / queue.size();
    }
}

class MovingAverageUsingArray {
    private int [] window;
    private int n, insert;
    private long sum;
    
    /** Initialize your data structure here. */
    public MovingAverageUsingArray(int size) {
        window = new int[size];
        insert = 0;
        sum = 0;
    }
    
    public double next(int val) {
        if (n < window.length)  n++;
        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;
        
        return (double)sum / n;
    }
}
