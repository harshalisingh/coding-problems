package oa;

import java.util.LinkedList;
import java.util.Queue;

/*
 * A processor to process a bunch of request, can only handle one, each execution of a task execution time up to q, 
 * and then perform the next task awaits. If a task is not executed before the finish into the tail, waiting for the next performance. 
 * Assume that as long as the task is not idle cpu after the start, that began after the cpu if it shows no idle for the task, 
 * in addition to the return value is the last Robin Round float.
	OA example:
	the INPUT: [0，1，4], [5, 2, 3], q = 3
	the Output:average wait time 2.3333333
	p1 into the team,
	Performing p1 3 seconds, the dequeue, t = 3;
	p2 enqueued, P1 (duration2 remaining second, new requestTime 3) into the team;
	Performing p2 (waiting time of 2 seconds) for two seconds, dequeue, t = 5;
	p3 into the team.
	Performing p1 (waiting time of 2 seconds) for two seconds, dequeue, t = 7;
	Execution p3 (wait 3 seconds) 3 seconds from the team.
 */
public class RoundRobin {
	static class Process
	{
		int arrTime;
		int runTime;
		public Process(int arrTime, int runTime)
		{
			this.arrTime = arrTime;
			this.runTime = runTime;
		}
	}
	public static double waitingTime(int[] arriveTime, int[] runTime, int slot)
	{
		Queue<Process> queue = new LinkedList<>();
		int i = 0, t = 0, wait = 0;
		while(i < arriveTime.length || !queue.isEmpty())
		{
			if(!queue.isEmpty())
			{
				Process peek = queue.poll();
				wait += (t - peek.arrTime);
				if(peek.runTime > slot) 
				{
					t += slot;
					peek.runTime -= slot;
					peek.arrTime = t;
				}
				else
				{
					t += peek.runTime;
					peek.runTime = 0;
					peek.arrTime = t;
				}
				while(i < arriveTime.length && arriveTime[i] <= t)
				{
					queue.offer(new Process(arriveTime[i], runTime[i]));
					i++;
				}

				if(peek.runTime != 0) queue.offer(peek);
			}
			else
			{
				queue.offer(new Process(arriveTime[i], runTime[i]));
				t = arriveTime[i];
				i++;
			}
		}
		return (wait + 0.0) / arriveTime.length;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arriveTime = {0, 1, 3, 9};
		int[] runTime = {2, 1, 7, 5};
		System.out.println(waitingTime(arriveTime, runTime, 2));
	}
}
