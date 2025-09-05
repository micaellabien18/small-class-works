import java.util.ArrayList;
import java.util.Scanner;

public class RoundRobinSchedulingAlgorithm {

    private static class Process {
        int arrivalTime;
        int burstTime;
        int remainingTime;
        int completionTime;

        Process(int arrivalTime, int burstTime) {
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nROUND ROBIN SCHEDULING ALGORITHM");
        System.out.println("===================================\n");

        int quantumTime = inputQuantum(scanner);
        ArrayList<Process> processes = inputProcesses(scanner);

        roundRobinScheduling(processes, quantumTime);

        scanner.close();
    }

    private static int inputQuantum(Scanner scanner) {
        System.out.print("Enter Time Quantum: ");
        return scanner.nextInt();
    }

    private static ArrayList<Process> inputProcesses(Scanner scanner) {
        System.out.print("Enter Number of Processes: ");
        int numProcesses = scanner.nextInt();

        ArrayList<Process> processes = new ArrayList<>();
        for (int i = 0; i < numProcesses; i++) {
            System.out.println("\nProcess " + (i + 1));
            System.out.print("  Arrival Time: ");
            int arrival = scanner.nextInt();
            System.out.print("  Burst Time: ");
            int burst = scanner.nextInt();
            processes.add(new Process(arrival, burst));
        }
        return processes;
    }

    private static void roundRobinScheduling(ArrayList<Process> processes, int quantumTime) {
        int currentTime = 0;
        int completed = 0;
        int numProcesses = processes.size();
        ArrayList<Integer> ganttChartTimes = new ArrayList<>();
        ArrayList<String> ganttChartProcesses = new ArrayList<>();

        ArrayList<Integer> queue = new ArrayList<>();
        boolean[] inQueue = new boolean[numProcesses];

        // Initialize queue with processes that arrive at time 0
        for (int i = 0; i < numProcesses; i++) {
            if (processes.get(i).arrivalTime <= currentTime) {
                queue.add(i);
                inQueue[i] = true;
            }
        }

        while (completed < numProcesses) {
            if (queue.isEmpty()) {
                // If no process in queue, jump to next arriving process
                int nextArrival = Integer.MAX_VALUE;
                int nextIndex = -1;
                for (int i = 0; i < numProcesses; i++) {
                    if (processes.get(i).remainingTime > 0 && processes.get(i).arrivalTime < nextArrival) {
                        nextArrival = processes.get(i).arrivalTime;
                        nextIndex = i;
                    }
                }
                currentTime = processes.get(nextIndex).arrivalTime;
                queue.add(nextIndex);
                inQueue[nextIndex] = true;
            }

            int idx = queue.remove(0);
            Process p = processes.get(idx);

            int timeSlice = Math.min(p.remainingTime, quantumTime);
            ganttChartTimes.add(currentTime);
            ganttChartProcesses.add("P" + (idx + 1));

            currentTime += timeSlice;
            p.remainingTime -= timeSlice;

            // Add newly arrived processes to queue
            for (int i = 0; i < numProcesses; i++) {
                if (!inQueue[i] && processes.get(i).remainingTime > 0 && processes.get(i).arrivalTime <= currentTime) {
                    queue.add(i);
                    inQueue[i] = true;
                }
            }

            // Re-add current process if not finished
            if (p.remainingTime > 0) {
                queue.add(idx);
            } else {
                p.completionTime = currentTime;
                completed++;
            }
        }

        ganttChartTimes.add(currentTime); // End time
        printResults(processes, ganttChartProcesses, ganttChartTimes);
    }

    private static void printResults(ArrayList<Process> processes, ArrayList<String> ganttProcesses,
                                     ArrayList<Integer> ganttTimes) {
        System.out.println("\nGantt Chart:");
        for (int i = 0; i < ganttProcesses.size(); i++) {
            System.out.print("|  " + ganttProcesses.get(i) + "  ");
        }
        System.out.println("|");

        for (int time : ganttTimes) {
            System.out.print(time + "     ");
        }
        System.out.println("\n");

        System.out.println("Process Table:");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("| Process | Arrival | Burst | Completion | Turnaround | Waiting |");
        System.out.println("-----------------------------------------------------------------");

        int totalTurnaround = 0, totalWaiting = 0;
        for (int i = 0; i < processes.size(); i++) {
            Process p = processes.get(i);
            int turnaround = p.completionTime - p.arrivalTime;
            int waiting = turnaround - p.burstTime;
            totalTurnaround += turnaround;
            totalWaiting += waiting;

            System.out.printf("|  P%-5d | %-7d | %-5d | %-10d | %-10d | %-7d |\n",
                    i + 1, p.arrivalTime, p.burstTime, p.completionTime, turnaround, waiting);
        }

        System.out.println("-----------------------------------------------------------------");
        System.out.printf("\nAverage Turnaround Time: %.2f ms\n", totalTurnaround / (double) processes.size());
        System.out.printf("Average Waiting Time: %.2f ms\n", totalWaiting / (double) processes.size());
    }
}
