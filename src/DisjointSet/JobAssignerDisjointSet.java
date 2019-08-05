package DisjointSet;

import java.util.ArrayList;
import java.util.Collections;

import GreedyAlgorithm.Job;

public class JobAssignerDisjointSet {
	
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
		
		ArrayList<Job> scheduledJobs = scheduleJobs(jobs);
		System.out.println("Output");
		for (Job job: scheduledJobs) {
			System.out.println(job.toString());
		}
	}
	
	public static ArrayList<Job> scheduleJobs(ArrayList<Job> jobs){
		ArrayList<Job> scheduledJobs = new ArrayList<Job>();
		
		int maxDeadline = findMaxDeadline(jobs);
		DisjointSet djSet = new DisjointSet(maxDeadline);
		
		for (Job job: jobs) {
			int availableSlot = djSet.find(job.getDeadline());
			
			if (availableSlot > 0) {
				djSet.merge(djSet.find(availableSlot - 1), availableSlot);
				scheduledJobs.add(job);
			}
		}
		return scheduledJobs;
	}
	
	public static int findMaxDeadline(ArrayList<Job> jobs) {
		int max = Integer.MIN_VALUE;
		for(Job job: jobs) {
			max = Math.max(job.getDeadline(), max);
		}
		return max;
	}
}
