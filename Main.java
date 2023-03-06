import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static int processId = 0;

    public static void main(String[] args) {
        int choice = 0;
        ReadyQueue readyQueue = ReadyQueue.getInstance();
        do {
            choice = showMenu();
            switch (choice) {
                case 1:
                    Process process = createProcess();
                    readyQueue.add(process);
                    System.out.println("New Process Created with ID " + process.getId());
                    break;

                case 2:
                    System.out.println("Terminating process...");
                    break;

                case 3:
                    System.out.println("Displaying System Status...");
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
        Process process = new Process(processId++, priority, cpuBurstTime, ioBurstTime, executionTime);
        return process;
    }
}