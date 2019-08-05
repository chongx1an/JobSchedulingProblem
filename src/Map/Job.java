package Map;

public class Job implements Comparable<Job>{
	private char id;
	private int startTime;
	private int finishTime;
	private int profit;
	private int deadline;
	
	public int getID() {
		return this.id;
	}
	
	public int getDeadline() {
		return this.deadline;
	}
	
	public Job(char id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
	
	public void assignTime(int startTime, int finishTime) {
		this.startTime = startTime;
		this.finishTime = finishTime;
	}
	
	public String toString() {
		return (id + "\t" + startTime + "\t" + finishTime + "\t" + deadline + "\t" + profit);
	}

	@Override
	public int compareTo(Job otherJob) {
		return otherJob.profit - this.profit;
	}
}
