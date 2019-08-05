package GreedyAlgorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class JobAssignerGreedy {
	
	public static void main(String[] args) {
		ArrayList<Job> jobs = new ArrayList<Job>();
		jobs.add(new Job('a', 2, 100));
		jobs.add(new Job('b', 1, 19));
		jobs.add(new Job('c', 2, 27));
		jobs.add(new Job('d', 1, 25));
		jobs.add(new Job('e', 3, 15));
		
		System.out.println("Input");
		for (Job job: jobs) {
			System.out.println(job.toString());
		}
		
		Collections.sort(jobs);
	
		ArrayList<Job> scheduledJobs = scheduleJob(jobs);
		
		System.out.println("Output");
		for (Job job: scheduledJobs) {
			System.out.println(job.toString());
		}
		
	}
	
	private static ArrayList<Job> scheduleJob(ArrayList<Job> jobs) {
		int size = jobs.size();
		Boolean[] slots = new Boolean[size];
		int[] result = new int[size];
		
		Arrays.fill(slots, false);
		
		ArrayList<Job> scheduledJobs = new ArrayList<Job>();
		
		for (int i = 0; i < size; i++) {
			Job job = jobs.get(i);
			for (int j = job.getDeadline() - 1; j >= 0; j--) {
				if(!slots[j]) {
					result[j] = i;
					job.assignTime(j, j+1);
					slots[j] = true;
					break;
				}
			}
			
		}
		
		for (int i = 0; i < size ; i++) {
			if(slots[i])
				scheduledJobs.add(jobs.get(result[i]));
		}
		return scheduledJobs;
	}
}
