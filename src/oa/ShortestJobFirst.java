package oa;

import java.util.PriorityQueue;
import java.util.Comparator;

/*
 * a processor to process a bunch of request, can only handle one, if it has a backlog of several requests, 
 * it will first perform a short duration that; for equal duration requests, 
 * the first implementation of the first arrival request processor. 
 * Q. How soon will the average request is processed. input: requestTimes [], each time a request reaches a processor; 
 * durations [] the duration of each request to be processed. 
 * Two arrays is one to one, and has been pressing requestTimes [] sorted from small to large.
 */
public class ShortestJobFirst {
	static class Process
    {
        int arrTime;
        int exeTime;
        public Process(int arrTime, int exeTime)
        {
            this.arrTime = arrTime;
            this.exeTime = exeTime;
        }
    }
    public static double SJF(int[] req, int[] dur)
    {
    	// corner case
        if (req == null || req.length == 0 || dur == null || dur.length == 0 || req.length != dur.length) {
            return 0;
        }

        PriorityQueue<Process> queue = new PriorityQueue<>(new Comparator<Process>()
        {
            @Override
            public int compare(Process a, Process b)
            {
            	// idea: first try to order by execution time,
                //       if execution time is equal, then order by request time
                if(a.exeTime == b.exeTime) 
                	return a.arrTime - b.arrTime;
                else 
                	return a.exeTime - b.exeTime;
            }
        });
        int curTime = 0, waitTime = 0, i = 0;
        while(i < req.length || !queue.isEmpty())
        {
            if(queue.isEmpty())
            {
                queue.offer(new Process(req[i], dur[i]));
                curTime = req[i];
                i++;
            }
            else
            {
            	// execute current process
                Process curProcess = queue.poll();
                waitTime += (curTime - curProcess.arrTime);
                curTime += curProcess.exeTime;
                
                // add waiting process to list
                while(i < req.length && req[i] <= curTime)
                {
                    queue.offer(new Process(req[i], dur[i]));
                    i++;
                }
            }
        }
        return (float) waitTime / req.length;
    }
    public static void main(String[] args)
    {
        int[] req = {1, 3, 3, 6, 6, 6, 7};
        int[] dur = {2 ,2 ,3 ,2, 4, 4, 2};
        System.out.println(SJF(req, dur));
    }
}
