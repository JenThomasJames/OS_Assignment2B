import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static int processId = 0;

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        int choice = 0;
        do {
            choice = showMenu();
            switch (choice) {
                case 1:
                    Process process = createProcess();
                    scheduler.addProcessToReadyQueue(process);
                    System.out.println("New Process Created with ID " + process.getId());
                    break;

                case 2:
                    System.out.println("Enter the ID of the process to terminate: ");
                    int processId = scan.nextInt();
                    boolean isDeleted = scheduler.interruptProcess(processId);
                    if (isDeleted) {
                        System.out.println("Deleted Process Created with ID " + processId);
                    } else {
                        System.out.println("Couldn't find any process with ID " + processId);
                    }
                    break;

                case 3:
                    scheduler.printStatus();
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please make a valid selection");
                    break;
            }
            System.out.println("Do you want to continue?(0 for no, 1 for yes)? : ");
            int continueProgram = scan.nextInt();
            if (continueProgram == 0)
                break;
        } while (choice != 4);
        System.out.println("Thanks for using the app. Bye :)");
    }

    public static int showMenu() {
        System.out.println("****************");
        System.out.println("1) Create Process");
        System.out.println("2) Terminate Process");
        System.out.println("3) Display System Status");
        System.out.println("4) Exit");
        System.out.println("****************");
        System.out.println("Choice: ");
        int choice = scan.nextInt();
        return choice;
    }

    public static Process createProcess() {
        System.out.println("Enter Priority: ");
        int priority = scan.nextInt();
        System.out.println("Enter CPU Burst Time: ");
        int cpuBurstTime = scan.nextInt();
        System.out.println("Enter IO Burst Time: ");
        int ioBurstTime = scan.nextInt();
        System.out.println("Enter Execution Time: ");
        int executionTime = scan.nextInt();
        Process process = new Process(++processId, priority, cpuBurstTime, ioBurstTime, executionTime);
        return process;
    }
}