
import java.util.*;

class Job {
    int id, deadline, profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class JobSequencing {

    static List<Job> jobSequencing(List<Job> jobs) {
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }
        boolean[] slots = new boolean[maxDeadline];
        List<Job> result = new ArrayList<>();

        for (Job job : jobs) {
            for (int j = Math.min(maxDeadline - 1, job.deadline - 1); j >= 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    result.add(job);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        );
        List<Job> result = jobSequencing(jobs);
        for (Job job : result) {
            System.out.println("Job ID: " + job.id + ", Profit: " + job.profit);
        }
    }
}
