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
