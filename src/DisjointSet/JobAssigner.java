package DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import ArrayList.Job;

public class JobAssigner {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		ArrayList<Job> jobs = new ArrayList<Job>();
		for (int i = 0; i < 100 ; i++) {
			jobs.add(new Job((char)i, random.nextInt(100)+1, random.nextInt(100)+1));
		}
		
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
