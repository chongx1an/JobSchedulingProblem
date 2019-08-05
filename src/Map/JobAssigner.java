package Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import ArrayList.Job;

public class JobAssigner {
	

	public static void main(String[] args) {
		
		
		List<Job> jobs = createJobs(5);
		
		System.out.println("Input");
		printJobs(jobs);
		
		Map<Integer, Job> scheduledJobs = scheduleJob(jobs);
		
		System.out.println("Output");
		printScheduledJobs(scheduledJobs);
		
	}
	
	private static void printJobs(List<Job> jobs) {
		for (Job job: jobs) {
			System.out.println(job.toString());
		}
	}
	
	private static void printScheduledJobs(Map<Integer, Job> scheduledJobs) {
		Iterator<Map.Entry<Integer, Job>> itr = scheduledJobs.entrySet().iterator(); 
        
        while(itr.hasNext()) 
        { 
             Map.Entry<Integer, Job> entry = itr.next(); 
             System.out.println(entry.getValue()); 
        } 
	}
	
	private static ArrayList<Job> createJobs(int size){
		Random random = new Random();
		
		ArrayList<Job> jobs = new ArrayList<Job>();
		for (int i = 97; i < 97 + size ; i++) {
			jobs.add(new Job((char)i, random.nextInt(size)+1, random.nextInt(100)+1));
		}
		return jobs;
	}
	private static Map<Integer, Job> scheduleJob(List<Job> jobs) {
		
		Collections.sort(jobs);

		Map<Integer, Job> scheduledJobs = new TreeMap<>();
		
		for (Job job:jobs) {
			int timeslot = job.getDeadline();
			
			while(timeslot > 0) {
				timeslot--;
				if (!scheduledJobs.containsKey(timeslot)) {
					job.assignTime(timeslot, timeslot+1);
					scheduledJobs.put(timeslot, job);
					break;
				}
			}
		}
		return scheduledJobs;
	}
}
