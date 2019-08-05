package ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class JobAssigner {
	
	public static void main(String[] args) {
		
		
		ArrayList<Job> jobs = createJobs(100);

		
		System.out.println("Input");
		printJobs(jobs);
		
		ArrayList<Job> scheduledJobs = scheduleJob(jobs);
		
		System.out.println("Output");
		printJobs(scheduledJobs);
		
	}
	
	private static void printJobs(ArrayList<Job> jobs) {
		for (Job job: jobs) {
			System.out.println(job.toString());
		}
	}
	
	private static ArrayList<Job> createJobs(int size){
		Random random = new Random();
		
		ArrayList<Job> jobs = new ArrayList<Job>();
		for (int i = 97; i < 123 ; i++) {
			jobs.add(new Job((char)i, random.nextInt(123-97)+1, random.nextInt(100)+1));
		}
		return jobs;
	}
	private static ArrayList<Job> scheduleJob(ArrayList<Job> jobs) {
		
		Collections.sort(jobs);
		
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
